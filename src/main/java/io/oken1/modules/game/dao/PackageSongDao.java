package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.PackageSongEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface PackageSongDao extends BaseMapper<PackageSongEntity> {
    List<PackageSongEntity> getPackageSongConfigListByPackageId(String packageId);

    List<LinkedHashMap> getExcludedSongListByPackageId(String packageId);
}
