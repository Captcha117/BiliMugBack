package io.oken1.modules.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.video.entity.DssqEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface DssqDao extends BaseMapper<DssqEntity> {
    List<LinkedHashMap> showTitleDssq(String startDate, String endDate);

    void insertTitleDssq(String startDate, String endDate);

    void manualInsertDssq(Long[] aids, String type);
}
