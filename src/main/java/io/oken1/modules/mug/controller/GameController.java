package io.oken1.modules.mug.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping("/listInEdit")
    //@RequiresPermissions("mug:mug:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = gameService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{gameId}")
    //@RequiresPermissions("mug:mug:info")
    public R info(@PathVariable("gameId") String gameId) {
        GameEntity game = gameService.getById(gameId);

        return R.ok().put("mug", game);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("mug:mug:save")
    public R save(@RequestBody GameEntity game) {
        gameService.save(game);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("mug:mug:update")
    public R update(@RequestBody GameEntity game) {
        gameService.updateById(game);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("mug:mug:delete")
    public R delete(@RequestBody String[] gameIds) {
        gameService.removeByIds(Arrays.asList(gameIds));

        return R.ok();
    }

    @RequestMapping("/gameList")
    public R gameList() {
        List<LinkedHashMap> result = gameService.getGameList();
        return R.ok().put("result", result);
    }

    @RequestMapping("/gameInfo")
    public R gameInfo(String gameId) {
        LinkedHashMap gameInfo = gameService.getGameInfoByGameId(gameId);
        List<LinkedHashMap> songList = gameService.getSongListByGameId(gameId);
        return R.ok().put("gameInfo", gameInfo).put("songList", songList);
    }
}
