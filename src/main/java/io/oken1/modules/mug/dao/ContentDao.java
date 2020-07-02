package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.ContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface ContentDao extends BaseMapper<ContentEntity> {
    List<LinkedHashMap> gameContent(String startDate, String endDate);

    List<LinkedHashMap> osuContent(String startDate, String endDate);

    void insertGameContent(String startDate, String endDate);

    void insertOsuContent(String startDate, String endDate);

    ContentEntity findContent(int aid, String contentId);
}
