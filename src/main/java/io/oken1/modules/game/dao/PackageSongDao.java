package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.PackageEntity;
import io.oken1.modules.game.entity.PackageSongEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PackageSongDao extends BaseMapper<PackageSongEntity> {
}
