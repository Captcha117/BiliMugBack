package io.oken1.modules.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.video.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface VideoDao extends BaseMapper<VideoEntity> {
    List<LinkedHashMap> getVideosByGameId(String gameId, String startDate, String endDate);

    List<LinkedHashMap> getVideosBySongId(String dongId);

    List<HashMap> getUpRank(String startDate, String date, Boolean needProportion);

    List<HashMap> getGameRank(String startDate, String date);

    List<HashMap> getRankWithoutDssq(String date);

    List<LinkedHashMap> getVideosByDates(Date startDate, Date endDate);

    List<LinkedHashMap> getProcessVideoList(String startDate, String endDate, Integer minPlay,
                                            String gameId, String search, Boolean isClassify, Boolean isDssq);
}
