package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.KeywordEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeywordDao extends BaseMapper<KeywordEntity> {
}
