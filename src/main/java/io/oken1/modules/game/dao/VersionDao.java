package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.VersionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface VersionDao extends BaseMapper<VersionEntity> {
    List<LinkedHashMap> getVersionConfigList();

    List<VersionEntity> getVersionConfigListByGameId(String gameId);
}
