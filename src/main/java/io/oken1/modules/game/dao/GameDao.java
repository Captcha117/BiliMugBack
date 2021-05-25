package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.GameEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;


@Mapper
public interface GameDao extends BaseMapper<GameEntity> {

    List<LinkedHashMap> getGameList();

    LinkedHashMap getGameInfoByGameId(String gameId);

    List<LinkedHashMap> getGamePlayData(String gameId, String startDate, String endDate, String type);

    /**
     * game后台配置表
     */
    List<LinkedHashMap> getGameConfigList();

    void gameFilterIndexIncrease(String gameId, Integer index);
}
