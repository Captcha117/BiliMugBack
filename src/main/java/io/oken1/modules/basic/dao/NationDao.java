package io.oken1.modules.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.basic.entity.NationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NationDao extends BaseMapper<NationEntity> {
    /**
     * nation后台配置表
     */
    List<NationEntity> getNationConfigList();
}
