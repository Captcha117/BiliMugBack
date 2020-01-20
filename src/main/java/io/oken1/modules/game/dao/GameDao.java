package io.oken1.modules.game.dao;

import io.oken1.modules.game.entity.GameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 
 * 
 * @author oken1
 * @email /
 * @date 2020-01-16 14:46:31
 */
@Mapper
public interface GameDao extends BaseMapper<GameEntity> {
	List<LinkedHashMap> getGameList();
	List<LinkedHashMap> getGameList2();
}
