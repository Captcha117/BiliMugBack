package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.ContentDao;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.service.ContentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service("ContentService")
public class ContentServiceImpl extends ServiceImpl<ContentDao, ContentEntity> implements ContentService {

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
    public Object updateContent(Long aid, String oldContent, String newType, String newContent) {
        ContentEntity contentEntity = new ContentEntity();
        // 非空则update
        if (!StringUtils.isBlank(oldContent)) {
            if (contentDao.getContent(aid, oldContent) == null) {
                return "未找到对应的content";
            } else if (contentDao.getContent(aid, newContent) == null) {
                return "content已存在";
            } else {
                contentEntity.setType(newType);
                contentEntity.setContentId(newContent);
                saveOrUpdate(contentEntity);
                return "success";
            }
        } else {
            // 否则add
            contentEntity.setAid(aid);
            contentEntity.setType(newType);
            contentEntity.setContentId(newContent);
            contentEntity.setKeyword("admin");
            saveOrUpdate(contentEntity);
            return "success";
        }
    }
}
