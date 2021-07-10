package io.oken1.modules.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.video.entity.GameContentEntity;

public interface ContentService extends IService<GameContentEntity> {
    Object showGameContent(String startDate, String endDate);

    Object insertGameContent(String startDate, String endDate);
}

