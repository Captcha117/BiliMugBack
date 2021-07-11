package io.oken1.modules.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.video.entity.DssqEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DssqDao extends BaseMapper<DssqEntity> {
    void insertTitleDssq(String startDate, String endDate);

    void manualInsertDssq(Long[] aids, String type);

    void removeDssq(Long[] aids);
}
