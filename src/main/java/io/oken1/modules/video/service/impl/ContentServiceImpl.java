package io.oken1.modules.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.video.dao.ContentDao;
import io.oken1.modules.video.entity.GameContentEntity;
import io.oken1.modules.video.service.ContentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service("ContentService")
public class ContentServiceImpl extends ServiceImpl<ContentDao, GameContentEntity> implements ContentService {

    @Autowired
    ContentDao contentDao;

    @Override
    public Object showGameContent(String startDate, String endDate) {
        List<LinkedHashMap> result = new ArrayList<>();
        List<LinkedHashMap> gameResult = contentDao.gameContent(startDate, endDate);
        List<LinkedHashMap> osuResult = contentDao.osuContent(startDate, endDate);
        result.addAll(gameResult);
        result.addAll(osuResult);
        return result;
    }

    @Override
    public Object insertGameContent(String startDate, String endDate) {
        try {
            contentDao.insertGameContent(startDate, endDate);
            contentDao.insertOsuContent(startDate, endDate);
        } catch (Exception e) {
            return e;
        }
        return "success";
    }

    @Override
    public Object updateGameContent(Long aid, String oldGameId, String newGameId) {
        GameContentEntity gameContentEntity = new GameContentEntity();
        // 非空则update
        if (StringUtils.isNotBlank(oldGameId)) {
            if (contentDao.getGameContent(aid, oldGameId) == null) {
                return "未找到对应的content";
            } else if (contentDao.getGameContent(aid, newGameId) == null) {
                return "content已存在";
            } else {
                gameContentEntity.setGameId(newGameId);
                saveOrUpdate(gameContentEntity);
                return "success";
            }
        } else {
            // 否则add
            gameContentEntity.setAid(aid);
            gameContentEntity.setGameId(newGameId);
            gameContentEntity.setKeyword("admin");
            saveOrUpdate(gameContentEntity);
            return "success";
        }
    }
}
