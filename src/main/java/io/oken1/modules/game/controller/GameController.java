package io.oken1.modules.game.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.game.dao.GameDao;
import io.oken1.modules.game.dao.GameDetailDao;
import io.oken1.modules.game.service.GameService;
import io.oken1.modules.music.dao.SongDao;
import io.oken1.modules.music.model.SongModel;
import io.oken1.modules.video.dao.RankDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;


@Api(value = "游戏数据", tags = {"游戏数据"})
@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameDao gameDao;

    @Autowired
    GameDetailDao gameDetailDao;

    @Autowired
    SongDao songDao;

    @Autowired
    RankDao rankDao;

    /**
     * 获取简要游戏列表
     *
     * @return 分类结果
     */
    @ApiOperation("获取简要游戏列表")
    @GetMapping("/gameList")
    public R gameList() {
        List<LinkedHashMap> result = gameService.getGameList();
        return R.ok().put("result", result);
    }

    @ApiOperation("游戏详细信息")
    @GetMapping("/gameInfo")
    public R gameInfo(String gameId) {
        LinkedHashMap gameInfo = gameDao.getGameInfoByGameId(gameId);
        List<SongModel> songList = songDao.getSongListByGameId(gameId);
        List<LinkedHashMap> versionList = gameDetailDao.getVersionListByGameId(gameId);
        List<LinkedHashMap> difficultyList = gameDetailDao.getDifficultyListByGameId(gameId);
        List<LinkedHashMap> snsList = gameDetailDao.getSnsListByGameId(gameId);
        List<LinkedHashMap> packageList = gameDetailDao.getPackageListByGameId(gameId);
        List<LinkedHashMap> rankList = rankDao.getUpRankByGameId(new String[]{gameId});

        return R.ok().put("gameInfo", gameInfo).put("songList", songList)
                .put("versionList", versionList).put("difficultyList", difficultyList)
                .put("snsList", snsList).put("packageList", packageList)
                .put("rankList", rankList);
    }

    @ApiOperation("游戏播放信息")
    @GetMapping("/gamePlayData")
    public R gamePlay(String gameId, String type) {
        List<LinkedHashMap> result = gameService.getGamePlayData(gameId, type);
        return R.ok().put("result", result);
    }

}
