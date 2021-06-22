package io.oken1.modules.video.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.video.dao.RankDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;


@Api(value = "视频-排名", tags = {"视频-排名"})
@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    RankDao rankDao;

    /**
     * 游戏排名
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 游戏排名结果
     */
    @ApiOperation("游戏排名")
    @GetMapping("/game")
    public R game(String startDate, String endDate) {
        List<LinkedHashMap> result = rankDao.gameRank(startDate, endDate);
        return R.ok().put("result", result);
    }

    /**
     * UP排名
     *
     * @param startDate      开始时间
     * @param endDate        结束时间
     * @param referStartDate 参考开始时间
     * @param referEndDate   参考结束时间
     * @return UP排名结果
     */
    @ApiOperation("UP排名")
    @GetMapping("/up")
    public R up(String startDate, String endDate, String referStartDate, String referEndDate) {
        List<LinkedHashMap> result = rankDao.upRank(startDate, endDate, referStartDate, referEndDate);
        return R.ok().put("result", result);
    }

    /**
     * 保存UP近一年排名
     */
    @ApiOperation("保存UP近一年排名")
    @GetMapping("/up/year")
    public R uploaderYearRank() {
        rankDao.insertUploaderYearRank();
        return R.ok();
    }
}
