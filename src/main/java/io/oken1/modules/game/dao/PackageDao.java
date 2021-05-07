package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.ChartEntity;
import io.oken1.modules.game.entity.PackageEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PackageDao extends BaseMapper<PackageEntity> {
}
