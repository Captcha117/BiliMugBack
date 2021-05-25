package io.oken1.modules.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.basic.entity.RegionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionDao extends BaseMapper<RegionEntity> {
    /**
     * region后台配置表
     */
    List<RegionEntity> getRegionConfigList();
}
