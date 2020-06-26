package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.ContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface ContentDao extends BaseMapper<ContentEntity> {
    void insertGameContent();

    List<LinkedHashMap> gameContent();
}
