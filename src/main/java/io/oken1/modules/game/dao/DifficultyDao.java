package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.DifficultyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface DifficultyDao extends BaseMapper<DifficultyEntity> {
    List<LinkedHashMap> getDifficultyConfigList();

    List<DifficultyEntity> getDifficultyConfigListByGameId(String gameId);
}
