package io.oken1.modules.game.controller;

import io.oken1.common.utils.R;
import io.oken1.common.utils.ShiroUtils;
import io.oken1.modules.game.dao.*;
import io.oken1.modules.game.entity.*;
import io.oken1.modules.game.service.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/game/saveOrUpdate/{increase}")
    public R gameSaveOrUpdate(@RequestBody GameEntity game, @PathVariable Boolean increase) {
        if (increase && game.getFilterIndex() > 0) {
            gameDao.gameFilterIndexIncrease(game.getGameId(), game.getFilterIndex());
        }
        gameService.saveOrUpdate(game);
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

    //region mug_chart
    @Autowired
    ChartService chartService;
    @Autowired
    ChartDao chartDao;

    @GetMapping("/chart/list/{songId}")
    public R chartListByGameId(@PathVariable("songId") String songId) {
        List<LinkedHashMap> result = chartDao.getChartConfigListBySongId(songId);
        return R.ok().put("result", result);
    }

    @GetMapping("/chart/info/{chartId}")
    public R chartInfo(@PathVariable("chartId") String chartId) {
        ChartEntity chart = chartService.getById(chartId);
        return R.ok().put("chartInfo", chart);
    }

    @GetMapping("/chart/attribute/{gameId}")
    public R chartAttribute(@PathVariable("gameId") String gameId) {
        List<DifficultyEntity> difficulty = difficultyDao.getDifficultyConfigListByGameId(gameId);
        return R.ok().put("difficultyList", difficulty);
    }

    @PostMapping("/chart/save")
    public R chartSave(@RequestBody List<ChartEntity> chart) {
        chartService.saveBatch(chart);
        return R.ok();
    }

    @PostMapping("/chart/update")
    public R chartUpdate(@RequestBody List<ChartEntity> chart) {
        chartService.updateBatchById(chart);
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

    @GetMapping("/version/list")
    //@RequiresPermissions("mug:mug:list")
    public R versionList() {
        List<LinkedHashMap> result = versionDao.getVersionConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/version/list/{gameId}")
    //@RequiresPermissions("mug:mug:list")
    public R versionListByGameId(@PathVariable("gameId") String gameId) {
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

    @GetMapping("/keyword/list")
    //@RequiresPermissions("mug:mug:list")
    public R keywordList() {
        List<LinkedHashMap> result = keywordDao.getKeywordConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/keyword/list/{gameId}")
    //@RequiresPermissions("mug:mug:list")
    public R keywordListByGameId(@PathVariable("gameId") String gameId) {
        List<KeywordEntity> result = keywordDao.getKeywordConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/keyword/info/{keywordId}")
    public R keywordInfo(@PathVariable("keywordId") String keywordId) {
        KeywordEntity keyword = keywordService.getById(keywordId);
        return R.ok().put("keywordInfo", keyword);
    }

    @PostMapping("/keyword/save/{increase}")
    public R keywordSave(@RequestBody KeywordEntity keyword, @PathVariable Boolean increase) {
        if (increase) {
            keywordDao.keywordIndexIncrease(keyword.getGameId(), keyword.getKeywordId(), keyword.getKeywordIndex());
        }
        keywordService.save(keyword);
        keyword.setUpdateUser(ShiroUtils.getUserId());
        return R.ok();
    }

    @PostMapping("/keyword/update/{increase}")
    public R keywordUpdate(@RequestBody KeywordEntity keyword, @PathVariable Boolean increase) {
        if (increase) {
            keywordDao.keywordIndexIncrease(keyword.getGameId(), keyword.getKeywordId(), keyword.getKeywordIndex());
        }
        keywordService.updateById(keyword);
        keyword.setUpdateUser(ShiroUtils.getUserId());
        return R.ok();
    }

    @PostMapping("/keyword/delete")
    public R keywordDelete(@RequestBody String[] keywordIds) {
        keywordService.removeByIds(Arrays.asList(keywordIds));

        return R.ok();
    }
    //endregion

    //region mug_package
    @Autowired
    PackageService packageService;
    @Autowired
    PackageDao packageDao;

    @GetMapping("/package/list")
    //@RequiresPermissions("mug:mug:list")
    public R packageList() {
        List<LinkedHashMap> result = packageDao.getPackageConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/package/list/{gameId}")
    //@RequiresPermissions("mug:mug:list")
    public R packageListByGameId(@PathVariable("gameId") String gameId) {
        List<LinkedHashMap> result = packageDao.getPackageConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/package/info/{packageId}")
    public R packageInfo(@PathVariable("packageId") String packageId) {
        PackageEntity packageEntity = packageService.getById(packageId);
        return R.ok().put("packageInfo", packageEntity);
    }

    @PostMapping("/package/saveOrUpdate")
    public R packageSaveOrUpdate(@RequestBody PackageEntity packageEntity) {
        packageService.saveOrUpdate(packageEntity);
        return R.ok();
    }

    @PostMapping("/package/delete")
    public R packageDelete(@RequestBody String[] packageIds) {
        packageService.removeByIds(Arrays.asList(packageIds));

        return R.ok();
    }
    //endregion

    //region mug_package_song
    @Autowired
    PackageSongService packageSongService;
    @Autowired
    PackageSongDao packageSongDao;

    @GetMapping("/packageSong/list/{packageId}")
    public R packageSongListByGameId(@PathVariable("packageId") String packageId) {
        List<PackageSongEntity> result = packageSongDao.getPackageSongConfigListByPackageId(packageId);
        return R.ok().put("result", result);
    }

    @GetMapping("/packageSong/list/excluded/{packageId}")
    public R getExcludedSongListByPackageId(@PathVariable("packageId") String packageId) {
        List<LinkedHashMap> result = packageSongDao.getExcludedSongListByPackageId(packageId);
        return R.ok().put("result", result);
    }

    @PostMapping("/packageSong/save/{packageId}")
    public R packageSongSaveOrUpdate(@PathVariable("packageId") String packageId, @RequestBody String[] packageSongIds) {
        List<PackageSongEntity> entities = new ArrayList<>();
        for (String id : packageSongIds) {
            PackageSongEntity entity = new PackageSongEntity();
            entity.setPackageId(packageId);
            entity.setSongId(id);
            entities.add(entity);
        }
        packageSongService.saveBatch(entities);
        return R.ok();
    }

    @PostMapping("/packageSong/delete")
    public R packageSongDelete(@RequestBody String[] packageSongIds) {
        packageSongService.removeByIds(Arrays.asList(packageSongIds));

        return R.ok();
    }
    //endregion
}
