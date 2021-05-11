package io.oken1.modules.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.basic.entity.SnsTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SnsTypeDao extends BaseMapper<SnsTypeEntity> {
    List<SnsTypeEntity> getSnsTypeConfigList();
}
