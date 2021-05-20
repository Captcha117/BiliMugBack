package io.oken1.modules.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.basic.entity.SnsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface SnsDao extends BaseMapper<SnsEntity> {
    List<LinkedHashMap> getSnsConfigList();
}
