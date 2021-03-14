package io.oken1.modules.mug.dao;

import io.oken1.modules.mug.entity.GameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;


@Mapper
public interface GameDao extends BaseMapper<GameEntity> {

    List<LinkedHashMap> getGameList();

    LinkedHashMap getGameInfoByGameId(String gameId);

    List<LinkedHashMap> getSongBySongId(String songId);

    List<LinkedHashMap> getGamePlayData(String gameId, String startDate, String endDate, String type);
}
