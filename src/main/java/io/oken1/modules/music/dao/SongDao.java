package io.oken1.modules.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.music.entity.SongEntity;
import io.oken1.modules.music.model.SongModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface SongDao extends BaseMapper<SongEntity> {
    List<SongModel> getSongListByGameId(String gameId);

    List<SongEntity> getBriefSongListByGameId(String gameId);

    LinkedHashMap getSongInfo(String songId);

    /**
     * 后台配置数据
     */
    List<LinkedHashMap> getSongConfigList();

    List<LinkedHashMap> getSongConfigListByGameId(String gameId);
}
