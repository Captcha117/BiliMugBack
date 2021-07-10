package io.oken1.modules.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.video.entity.GameContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface ContentDao extends BaseMapper<GameContentEntity> {
    List<LinkedHashMap> gameContent(String startDate, String endDate);

    List<LinkedHashMap> osuContent(String startDate, String endDate);

    void insertGameContent(String startDate, String endDate);

    void insertOsuContent(String startDate, String endDate);

    GameContentEntity getGameContent(Long aid, String gameId);

    void deleteContentByAids(List<Long> aids);
}
