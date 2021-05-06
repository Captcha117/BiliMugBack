package io.oken1.modules.mug.controller;

import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;
import io.oken1.modules.mug.dao.GameDao;
import io.oken1.modules.mug.dao.GameDetailDao;
import io.oken1.modules.mug.entity.GameEntity;
import io.oken1.modules.mug.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Api(value = "游戏接口", tags = {"游戏接口"})
@RestController
@RequestMapping("/mug/game")
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameDao gameDao;

    @Autowired
    GameDetailDao gameDetailDao;

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
        LinkedHashMap gameInfo = gameService.getGameInfoByGameId(gameId);
        List<LinkedHashMap> songList = gameService.getSongListByGameId(gameId);
        List<LinkedHashMap> versionList = gameDetailDao.getVersionListByGameId(gameId);
        List<LinkedHashMap> difficultyList = gameDetailDao.getDifficultyListByGameId(gameId);
        List<LinkedHashMap> snsList = gameDetailDao.getSnsListByGameId(gameId);
        List<LinkedHashMap> packageList = gameDetailDao.getPackageListByGameId(gameId);

        return R.ok().put("gameInfo", gameInfo).put("songList", songList)
                .put("versionList", versionList).put("difficultyList", difficultyList)
                .put("snsList", snsList).put("packageList", packageList);
    }

    @ApiOperation("游戏播放信息")
    @GetMapping("/gamePlayData")
    public R gamePlay(String gameId, String type) {
        List<LinkedHashMap> result = gameService.getGamePlayData(gameId, type);
        return R.ok().put("result", result);
    }
}
