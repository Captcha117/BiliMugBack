package io.oken1.modules.data.dao;

import io.oken1.modules.data.entity.GameDataEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameDataDao {
    List<GameDataEntity> getGameList();

    GameDataEntity getGameInfo(String gameId);
}