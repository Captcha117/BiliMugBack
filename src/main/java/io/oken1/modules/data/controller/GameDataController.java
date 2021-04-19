package io.oken1.modules.data.controller;

import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;
import io.oken1.modules.data.dao.GameDataDao;
import io.oken1.modules.data.entity.GameDataEntity;
import io.oken1.modules.mug.service.GameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "游戏后台数据接口", tags = {"游戏后台数据接口"})
@RestController
@RequestMapping("/mug/data")
/**
 * 游戏后台数据控制器，主要配置游戏、关键词、公司
 */
public class GameDataController {
    @Autowired
    GameDataDao gameDatadao;

    /**
     * mug_game列表
     */
    @GetMapping("/game/list")
    //@RequiresPermissions("mug:mug:list")
    public R list() {
        List<GameDataEntity> result = gameDatadao.getGameList();
        return R.ok().put("result", result);
    }
}
