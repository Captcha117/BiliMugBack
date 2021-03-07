package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.mug.entity.GameEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface GameService extends IService<GameEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<LinkedHashMap> getGameList();

    LinkedHashMap getGameInfoByGameId(String gameId);

    List<LinkedHashMap> getSongListByGameId(String gameId);

    List<LinkedHashMap> getGamePlayData(String gameId, String type);
}

