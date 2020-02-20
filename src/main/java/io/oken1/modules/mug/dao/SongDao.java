package io.oken1.modules.mug.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.mug.entity.SongEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;

@Mapper
public interface SongDao extends BaseMapper<SongEntity> {
    LinkedHashMap getSongInfo(String songId);
}
