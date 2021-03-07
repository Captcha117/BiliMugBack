package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.GameContentEntity;

public interface ContentService extends IService<GameContentEntity> {
    Object showGameContent(String startDate, String endDate);

    Object insertGameContent(String startDate, String endDate);

    Object updateGameContent(Long aid, String oldGameId, String newGameId);
}

