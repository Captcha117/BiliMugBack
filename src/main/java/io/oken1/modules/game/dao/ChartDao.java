package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.ChartEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface ChartDao extends BaseMapper<ChartEntity> {
    List<LinkedHashMap> getChartConfigListBySongId(String songId);
}
