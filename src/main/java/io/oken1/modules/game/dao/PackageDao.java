package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.PackageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface PackageDao extends BaseMapper<PackageEntity> {
    List<LinkedHashMap> getPackageConfigList();

    List<PackageEntity> getPackageConfigListByGameId(String gameId);
}
