package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.ContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface ContentDao extends BaseMapper<ContentEntity> {
    List<LinkedHashMap> gameContent(String startDate);

    List<LinkedHashMap> osuContent(String startDate);

    void insertGameContent(String startDate);

    void insertOsuContent(String startDate);
}
