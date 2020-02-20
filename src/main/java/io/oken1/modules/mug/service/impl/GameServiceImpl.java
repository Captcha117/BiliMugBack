package io.oken1.modules.mug.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.mug.dao.GameDao;
import io.oken1.modules.mug.entity.GameEntity;
import io.oken1.modules.mug.service.GameService;


@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Autowired
    private GameDao gameDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GameEntity> page = this.page(
                new Query<GameEntity>().getPage(params),
                new QueryWrapper<GameEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LinkedHashMap> getGameList() {
        return gameDao.getGameList();
    }

    @Override
    public LinkedHashMap getGameInfoByGameId(String gameId) {
        return gameDao.getGameInfoByGameId(gameId);
    }

    @Override
    public List<LinkedHashMap> getSongListByGameId(String gameId) {
        return gameDao.getSongsByGameId(gameId);
    }
}