package io.oken1.modules.data.controller;

import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;
import io.oken1.modules.data.dao.GameDataDao;
import io.oken1.modules.data.entity.GameDataEntity;
import io.oken1.modules.mug.entity.CompanyEntity;
import io.oken1.modules.mug.entity.GameEntity;
import io.oken1.modules.mug.service.CompanyService;
import io.oken1.modules.mug.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Api(value = "后台数据接口-游戏", tags = {"后台数据接口-游戏"})
@RestController
@RequestMapping("/mug/data/game")
/**
 * 游戏后台数据控制器，主要配置游戏、关键词、公司
 */
public class GameDataController {
    @Autowired
    GameDataDao gameDatadao;

    @Autowired
    GameService gameService;

    @Autowired
    CompanyService companyService;

    //region 游戏 game

    /**
     * mug_game列表
     */
    @GetMapping("/game/list")
    //@RequiresPermissions("mug:mug:list")
    public R gameList() {
        List<GameDataEntity> result = gameDatadao.getGameList();
        return R.ok().put("result", result);
    }

    @GetMapping("/game/info/{gameId}")
    //@RequiresPermissions("mug:mug:info")
    public R gameInfo(@PathVariable("gameId") String gameId) {
        GameEntity game = gameService.getById(gameId);
        return R.ok().put("gameInfo", game);
    }

    @PostMapping("/game/save")
    //@RequiresPermissions("mug:mug:save")
    public R gameSave(@RequestBody GameEntity game) {
        gameService.save(game);
        return R.ok();
    }

    @PostMapping("/game/update")
    //@RequiresPermissions("mug:mug:update")
    public R gameUpdate(@RequestBody GameEntity game) {
        gameService.updateById(game);
        return R.ok();
    }

    @PostMapping("/game/delete")
    //@RequiresPermissions("mug:mug:delete")
    public R gameDelete(@RequestBody String[] gameIds) {
        gameService.removeByIds(Arrays.asList(gameIds));

        return R.ok();
    }
    //endregion

    //region 公司 company

    /**
     * mug_company列表
     */
    @RequestMapping("/company/list")
    public R companyList() {
        List<CompanyEntity> result = gameDatadao.getCompanyList();
        return R.ok().put("result", result);
    }

    @GetMapping("/company/info/{companyId}")
    //@RequiresPermissions("mug:mug:info")
    public R companyInfo(@PathVariable("companyId") String companyId) {
        CompanyEntity company = companyService.getById(companyId);
        return R.ok().put("companyInfo", company);
    }

    @PostMapping("/company/save")
    //@RequiresPermissions("mug:mug:save")
    public R companySave(@RequestBody CompanyEntity company) {
        companyService.save(company);
        return R.ok();
    }

    @PostMapping("/company/update")
    //@RequiresPermissions("mug:mug:update")
    public R companyUpdate(@RequestBody CompanyEntity company) {
        companyService.updateById(company);
        return R.ok();
    }

    @PostMapping("/company/delete")
    //@RequiresPermissions("mug:mug:delete")
    public R companyDelete(@RequestBody String[] companyIds) {
        companyService.removeByIds(Arrays.asList(companyIds));

        return R.ok();
    }
    //endregion
}
