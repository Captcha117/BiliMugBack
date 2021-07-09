package io.oken1.modules.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.game.entity.GameEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface GameService extends IService<GameEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<LinkedHashMap> getGameList();

    List<LinkedHashMap> getGamePlayData(String gameId, String type);
}

