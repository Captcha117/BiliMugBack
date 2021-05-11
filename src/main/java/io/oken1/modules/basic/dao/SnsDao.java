package io.oken1.modules.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.basic.entity.SnsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SnsDao extends BaseMapper<SnsEntity> {
}
