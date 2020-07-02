package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.entity.GameEntity;
import io.oken1.modules.mug.entity.SongEntity;

import java.util.Date;
import java.util.LinkedHashMap;

public interface ContentService extends IService<ContentEntity> {
    Object gameContent(String startDate, String endDate);

    Object insertGameContent(String startDate, String endDate);

    Object updateContent(int aid, String oldContent, String newType, String newContent);
}

