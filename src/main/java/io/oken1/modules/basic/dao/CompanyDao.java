package io.oken1.modules.basic.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.basic.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyDao extends BaseMapper<CompanyEntity> {
    /**
     * company后台配置表
     */
    List<CompanyEntity> getCompanyConfigList();
}
