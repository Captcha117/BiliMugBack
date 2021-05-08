package io.oken1.modules.game.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.game.dao.*;
import io.oken1.modules.game.entity.*;
import io.oken1.modules.game.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "游戏数据配置", tags = {"游戏数据配置"})
@RestController
@RequestMapping("/config")
public class GameConfigController {
    // region mug_game
    @Autowired
    GameService gameService;
    @Autowired
    GameDao gameDao;

    @GetMapping("/game/list")
    //@RequiresPermissions("mug:mug:list")
    public R gameList() {
        List<LinkedHashMap> result = gameDao.getGameConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/game/info/{gameId}")
    public R gameInfo(@PathVariable("gameId") String gameId) {
        GameEntity game = gameService.getById(gameId);
        return R.ok().put("gameInfo", game);
    }

    @PostMapping("/game/save")
    public R gameSave(@RequestBody GameEntity game) {
        gameService.save(game);
        return R.ok();
    }

    @PostMapping("/game/update")
    public R gameUpdate(@RequestBody GameEntity game) {
        gameService.updateById(game);
        return R.ok();
    }

    @PostMapping("/game/delete")
    public R gameDelete(@RequestBody String[] gameIds) {
        gameService.removeByIds(Arrays.asList(gameIds));

        return R.ok();
    }
    // endregion

    //region mug_difficulty
    @Autowired
    DifficultyService difficultyService;
    @Autowired
    DifficultyDao difficultyDao;

    @GetMapping("/difficulty/list")
    //@RequiresPermissions("mug:mug:list")
    public R difficultyList() {
        List<LinkedHashMap> result = difficultyDao.getDifficultyConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/difficulty/list/{gameId}")
    public R difficultyListByGameId(@PathVariable("gameId") String gameId) {
        List<DifficultyEntity> result = difficultyDao.getDifficultyConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/difficulty/info/{difficultyId}")
    public R difficultyInfo(@PathVariable("difficultyId") String difficultyId) {
        DifficultyEntity difficulty = difficultyService.getById(difficultyId);
        return R.ok().put("difficultyInfo", difficulty);
    }

    @PostMapping("/difficulty/save")
    public R difficultySave(@RequestBody DifficultyEntity difficulty) {
        difficultyService.save(difficulty);
        return R.ok();
    }

    @PostMapping("/difficulty/update")
    public R difficultyUpdate(@RequestBody DifficultyEntity difficulty) {
        difficultyService.updateById(difficulty);
        return R.ok();
    }

    @PostMapping("/difficulty/delete")
    public R difficultyDelete(@RequestBody String[] difficultyIds) {
        difficultyService.removeByIds(Arrays.asList(difficultyIds));

        return R.ok();
    }
    //endregion

    //region mug_mode
    @Autowired
    ModeService modeService;
    @Autowired
    ModeDao modeDao;

    @GetMapping("/mode/list")
    //@RequiresPermissions("mug:mug:list")
    public R modeList() {
        List<LinkedHashMap> result = modeDao.getModeConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/mode/list/{gameId}")
    public R modeListByGameId(@PathVariable("gameId") String gameId) {
        List<ModeEntity> result = modeDao.getModeConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/mode/info/{modeId}")
    public R modeInfo(@PathVariable("modeId") String modeId) {
        ModeEntity mode = modeService.getById(modeId);
        return R.ok().put("modeInfo", mode);
    }

    @PostMapping("/mode/save")
    public R modeSave(@RequestBody ModeEntity mode) {
        modeService.save(mode);
        return R.ok();
    }

    @PostMapping("/mode/update")
    public R modeUpdate(@RequestBody ModeEntity mode) {
        modeService.updateById(mode);
        return R.ok();
    }

    @PostMapping("/mode/delete")
    public R modeDelete(@RequestBody String[] modeIds) {
        modeService.removeByIds(Arrays.asList(modeIds));

        return R.ok();
    }

    //endregion

    //region mug_chart
    @Autowired
    ChartService chartService;
    @Autowired
    ChartDao chartDao;

    @GetMapping("/chart/list/{gameId}")
    public R chartListByGameId(@PathVariable("gameId") String gameId) {
        List<LinkedHashMap> result = chartDao.getChartConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/chart/info/{chartId}")
    public R chartInfo(@PathVariable("chartId") String chartId) {
        ChartEntity chart = chartService.getById(chartId);
        return R.ok().put("chartInfo", chart);
    }

    @PostMapping("/chart/save")
    public R chartSave(@RequestBody ChartEntity chart) {
        chartService.save(chart);
        return R.ok();
    }

    @PostMapping("/chart/update")
    public R chartUpdate(@RequestBody ChartEntity chart) {
        chartService.updateById(chart);
        return R.ok();
    }

    @PostMapping("/chart/delete")
    public R chartDelete(@RequestBody String[] chartIds) {
        chartService.removeByIds(Arrays.asList(chartIds));

        return R.ok();
    }
    //endregion

    //region mug_version
    @Autowired
    VersionService versionService;
    @Autowired
    VersionDao versionDao;

    @GetMapping("/version/list/{gameId}")
    //@RequiresPermissions("mug:mug:list")
    public R versionList(@PathVariable("gameId") String gameId) {
        List<VersionEntity> result = versionDao.getVersionConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/version/info/{versionId}")
    public R versionInfo(@PathVariable("versionId") String versionId) {
        VersionEntity version = versionService.getById(versionId);
        return R.ok().put("versionInfo", version);
    }

    @PostMapping("/version/save")
    public R versionSave(@RequestBody VersionEntity version) {
        versionService.save(version);
        return R.ok();
    }

    @PostMapping("/version/update")
    public R versionUpdate(@RequestBody VersionEntity version) {
        versionService.updateById(version);
        return R.ok();
    }

    @PostMapping("/version/delete")
    public R versionDelete(@RequestBody String[] versionIds) {
        versionService.removeByIds(Arrays.asList(versionIds));

        return R.ok();
    }
    //endregion

    //region mug_keyword
    @Autowired
    KeywordService keywordService;
    @Autowired
    KeywordDao keywordDao;

    @GetMapping("/keyword/list/{gameId}")
    //@RequiresPermissions("mug:mug:list")
    public R keywordList(@PathVariable("gameId") String gameId) {
        List<KeywordEntity> result = keywordDao.getKeywordConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/keyword/info/{keywordId}")
    public R keywordInfo(@PathVariable("keywordId") String keywordId) {
        KeywordEntity keyword = keywordService.getById(keywordId);
        return R.ok().put("keywordInfo", keyword);
    }

    @PostMapping("/keyword/save")
    public R keywordSave(@RequestBody KeywordEntity keyword) {
        keywordService.save(keyword);
        return R.ok();
    }

    @PostMapping("/keyword/update")
    public R keywordUpdate(@RequestBody KeywordEntity keyword) {
        keywordService.updateById(keyword);
        return R.ok();
    }

    @PostMapping("/keyword/delete")
    public R keywordDelete(@RequestBody String[] keywordIds) {
        keywordService.removeByIds(Arrays.asList(keywordIds));

        return R.ok();
    }
    //endregion
}
