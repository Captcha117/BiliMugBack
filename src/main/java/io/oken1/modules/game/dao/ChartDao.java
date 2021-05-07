package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.ChartEntity;
import io.oken1.modules.game.entity.DifficultyEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChartDao extends BaseMapper<ChartEntity> {
}
