package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.ContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface RankDao {
    List<LinkedHashMap> gameRank(String startDate, String endDate);

    List<LinkedHashMap> upRank(String startDate, String endDate, String referStartDate, String referEndDate);
}
