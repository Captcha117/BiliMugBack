package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.ContentDao;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service("ContentService")
public class ContentServiceImpl extends ServiceImpl<ContentDao, ContentEntity> implements ContentService {

    @Autowired
    ContentDao contentDao;

    @Override
    public Object gameContent() {
        List<LinkedHashMap> result = contentDao.gameContent();
        return result;
    }

    @Override
    public Object insertGameContent() {
        try {
            contentDao.insertGameContent();
        } catch (Exception e) {
            return e;
        }
        return "success";
    }
}
