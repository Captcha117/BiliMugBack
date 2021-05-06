package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao extends BaseMapper<CompanyEntity> {
}
