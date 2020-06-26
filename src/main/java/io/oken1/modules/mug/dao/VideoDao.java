package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface VideoDao extends BaseMapper<VideoEntity> {
    List<LinkedHashMap> getVideosByGameId(String gameId);

    List<LinkedHashMap> getVideosBySongId(String dongId);

    List<HashMap> getRank(String date);

    List<HashMap> getRankWithoutDssq(String date);

    List<LinkedHashMap> getVideosByDates(Date startDate, Date endDate);
}
