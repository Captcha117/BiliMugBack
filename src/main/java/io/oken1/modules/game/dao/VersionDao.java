package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.VersionEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VersionDao extends BaseMapper<VersionEntity> {
}
