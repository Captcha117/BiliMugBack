package io.oken1.modules.game.service.impl;

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

import io.oken1.modules.game.dao.GameDao;
import io.oken1.modules.game.entity.GameEntity;
import io.oken1.modules.game.service.GameService;


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
        return null;
    }

    @Override
    public List<LinkedHashMap> getGameList2() {
        return gameDao.getGameList2();
    }
}