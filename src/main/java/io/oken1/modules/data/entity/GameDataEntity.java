package io.oken1.modules.data.entity;

import io.oken1.modules.mug.entity.GameEntity;
import lombok.Data;

@Data
public class GameDataEntity extends GameEntity {
    /**
     * 关键词
     */
    private String keywords;
}
