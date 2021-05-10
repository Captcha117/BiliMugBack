package io.oken1.modules.game.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.game.entity.KeywordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface KeywordDao extends BaseMapper<KeywordEntity> {
    List<LinkedHashMap> getKeywordConfigList();

    List<KeywordEntity> getKeywordConfigListByGameId(String gameId);
}
