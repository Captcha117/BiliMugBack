package io.oken1.modules.video.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.GameEntity;
import io.oken1.modules.video.entity.VideoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author oken1
 * @email /
 * @date 2020-01-16 14:46:31
 */
@Mapper
public interface VideoDao extends BaseMapper<VideoEntity> {
    List<LinkedHashMap> getVideosByGameId(String gameID);
}
