package io.oken1.modules.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.music.entity.SingleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingleDao extends BaseMapper<SingleEntity> {
}
