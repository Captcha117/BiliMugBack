package io.oken1.modules.mug.service.impl;

import io.oken1.common.utils.DateUtils;
import io.oken1.modules.mug.dao.SongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.mug.dao.GameDao;
import io.oken1.modules.mug.entity.GameEntity;
import io.oken1.modules.mug.service.GameService;

@Service("GameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private SongDao songDao;

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
        List<LinkedHashMap> list = songDao.getSongsByGameId(gameId);
        for (LinkedHashMap l : list
        ) {
            List<HashMap> charts = (List<HashMap>) l.get("Charts");
            for (HashMap c : charts
            ) {
                l.put(c.get("DifficultyName").toString(), c.get("Level").toString());
            }
            l.remove("Charts");
        }
        return list;
    }

    @Override
    public List<LinkedHashMap> getGamePlayData(String gameId, String type) {
        Date end = new Date();
        Date start;
        switch (type) {
            default:
            case "D":
                start = DateUtils.addDateDays(end, -80);
                break;
            case "W":
                start = DateUtils.addDateDays(end, -80 - end.getDay());
                break;
            case "M":
                start = DateUtils.addDateMonths(end, -6);
                break;
        }
        List<LinkedHashMap> result = gameDao.getGamePlayData(gameId, DateUtils.format(start), DateUtils.format(end), type);
        return result;
    }
}