package io.oken1.modules.mug.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.modules.mug.entity.GameEntity;
import io.oken1.modules.mug.service.GameService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;


@Api(value = "游戏接口", tags = {"游戏接口"})
@RestController
@RequestMapping("/mug/game")
public class GameController {
    @Autowired
    GameService gameService;

    /**
     * 列表
     */
    @GetMapping("/pageList")
    //@RequiresPermissions("mug:mug:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = gameService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{gameId}")
    //@RequiresPermissions("mug:mug:info")
    public R info(@PathVariable("gameId") String gameId) {
        GameEntity game = gameService.getById(gameId);

        return R.ok().put("gameInfo", game);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    //@RequiresPermissions("mug:mug:save")
    public R save(@RequestBody GameEntity game) {
        gameService.save(game);

        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    //@RequiresPermissions("mug:mug:update")
    public R update(@RequestBody GameEntity game) {
        gameService.updateById(game);

        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    //@RequiresPermissions("mug:mug:delete")
    public R delete(@RequestBody String[] gameIds) {
        gameService.removeByIds(Arrays.asList(gameIds));

        return R.ok();
    }

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

    @GetMapping("/gameInfo")
    public R gameInfo(Integer gameId) {
        LinkedHashMap gameInfo = gameService.getGameInfoByGameId(gameId);
        List<LinkedHashMap> songList = gameService.getSongListByGameId(gameId);
        return R.ok().put("gameInfo", gameInfo).put("songList", songList);
    }
}
