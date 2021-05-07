package io.oken1.modules.game.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.game.dao.GameDao;
import io.oken1.modules.game.entity.GameDataEntity;
import io.oken1.modules.game.entity.GameEntity;
import io.oken1.modules.game.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(value = "游戏数据配置", tags = {"游戏数据配置"})
@RestController
@RequestMapping("/config")
public class GameConfigController {

    @Autowired
    GameService gameService;
    @Autowired
    GameDao gameDao;

    // region mug_game
    @GetMapping("/game/list")
    //@RequiresPermissions("mug:mug:list")
    public R gameList() {
        List<GameDataEntity> result = gameDao.getGameConfigList();
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

    //region mug_mode

    //endregion
}
