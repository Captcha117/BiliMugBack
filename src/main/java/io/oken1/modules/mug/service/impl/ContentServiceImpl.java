package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.ContentDao;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.service.ContentService;
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
    public Object gameContent(String startDate) {
        List<LinkedHashMap> result = new ArrayList<>();
        List<LinkedHashMap> gameResult = contentDao.gameContent(startDate);
        List<LinkedHashMap> osuResult = contentDao.osuContent(startDate);
        result.addAll(gameResult);
        result.addAll(osuResult);
        return result;
    }

    @Override
    public Object insertGameContent(String startDate) {
        try {
            contentDao.insertGameContent(startDate);
            contentDao.insertOsuContent(startDate);
        } catch (Exception e) {
            return e;
        }
        return "success";
    }

    @Override
    public Object updateContent(String aid, String oldContent, String newType, String newContent) {
        ContentEntity contentEntity = null;
        if (contentEntity == null) {

        }
        return null;
    }
}
