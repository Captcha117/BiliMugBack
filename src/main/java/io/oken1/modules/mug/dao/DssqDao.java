package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.DssqEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface DssqDao extends BaseMapper<DssqEntity> {
    List<LinkedHashMap> showDssq(String startDate, String endDate);

    void insertDssq(String startDate, String endDate);
}
