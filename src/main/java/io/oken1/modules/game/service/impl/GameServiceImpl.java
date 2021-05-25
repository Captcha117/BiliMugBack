package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.DateUtils;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;
import io.oken1.modules.game.dao.GameDao;
import io.oken1.modules.game.entity.GameEntity;
import io.oken1.modules.game.service.GameService;
import io.oken1.modules.music.dao.SongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<LinkedHashMap> list = songDao.getSongListByGameId(gameId);
        for (LinkedHashMap l : list
        ) {
            List<HashMap> charts = (List<HashMap>) l.get("charts");
            for (HashMap c : charts
            ) {
                l.put(c.get("difficultyName"), c.get("chartLevel"));
            }
            l.remove("charts");
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
                start = DateUtils.addDateMonths(end, -1);
                break;
            case "W":
                start = DateUtils.addDateDays(end, -84 - end.getDay());
                break;
            case "M":
                start = DateUtils.addDateMonths(end, -12);
                break;
        }
        List<LinkedHashMap> result = gameDao.getGamePlayData(gameId, DateUtils.format(start), DateUtils.format(end), type);
        return result;
    }
}