package io.oken1.modules.video.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.oken1.common.utils.R;
import io.oken1.modules.video.dao.DssqDao;
import io.oken1.modules.video.dao.VideoDao;
import io.oken1.modules.video.entity.GameContentEntity;
import io.oken1.modules.video.entity.VideoEntity;
import io.oken1.modules.video.service.ContentService;
import io.oken1.modules.video.service.DssqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "视频-内容处理", tags = {"视频-内容处理"})
@RestController
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    ContentService contentService;

    @Autowired
    DssqService dssqService;

    @Autowired
    VideoDao videoDao;

    @Autowired
    DssqDao dssqDao;

    /**
     * 显示根据游戏自动分类的结果
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 根据游戏分类的结果
     */
    @ApiOperation("显示根据游戏自动分类的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query")
    })
    @GetMapping("/showGameContent")
    public R gameContent(String startDate, String endDate) {
        if (StringUtils.isBlank(startDate)) {
            return R.error();
        }
        Object result = contentService.showGameContent(startDate, endDate);
        return R.ok().put("result", result);
    }

    /**
     * 添加根据游戏自动分类的结果
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 添加结果
     */
    @ApiOperation("添加根据游戏自动分类的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query")
    })
    @PostMapping("/insertGameContent")
    public R insertGameContent(String startDate, String endDate) {
        if (StringUtils.isBlank(startDate)) {
            return R.error();
        }
        Object result = contentService.insertGameContent(startDate, endDate);
        return R.ok().put("result", result);
    }

    /**
     * 更新视频的游戏分类
     *
     * @param aid       视频AV号
     * @param oldGameId 旧游戏ID
     * @param newGameId 新游戏ID
     * @return 视频内容更新结果
     */
    @ApiOperation("更新视频的游戏分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "视频AV号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "oldGameId", value = "旧游戏ID", paramType = "query"),
            @ApiImplicitParam(name = "newGameId", value = "新游戏ID", required = true, paramType = "query")
    })
    @PostMapping("/updateGameContent")
    public R updateGameContent(Long aid, String oldGameId, String newGameId) {
        Object result = contentService.updateGameContent(aid, oldGameId, newGameId);
        return R.ok().put("result", result);
    }

    /**
     * 批量更新视频的游戏分类
     *
     * @param contents 更新json字符串
     * @return 批量视频内容更新结果
     */
    @ApiOperation("批量更新视频的游戏分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contents", value = "更新json字符串", required = true, paramType = "query"),
    })
    @PostMapping("/updateGameContentBatch")
    public R updateGameContentBatch(@RequestBody String contents) {
        LinkedHashMap data = (LinkedHashMap) JSONUtils.parse(contents);
        JSONArray jsonArr = JSONArray.parseArray((String) data.get("contents"));
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject o = jsonArr.getJSONObject(i);
            Object result = contentService.updateGameContent(Long.valueOf(String.valueOf(o.get("aid"))), (String) o.get("oldGameId"), (String) o.get("newGameId"));
        }
        return R.ok();
    }

    /**
     * 批量更新视频内容
     *
     * @param contents 视频内容
     * @return 批量更新视频结果
     */
    @ApiOperation("批量更新视频内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contents", value = "视频内容", required = true, paramType = "query"),
    })
    @PostMapping("/updateContents")
    public R updateContents(@RequestBody String contents) {
        LinkedHashMap data = (LinkedHashMap) JSONUtils.parse(contents);
        JSONArray jsonArr = JSONArray.parseArray((String) data.get("contents"));
        List<GameContentEntity> list = jsonArr.toJavaList(GameContentEntity.class);

        Object result = contentService.saveOrUpdateBatch(list);
        return R.ok().put("result", result);
    }

    /**
     * 获取未分类的视频
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param minPlay   最低播放量
     * @return 未分类的视频信息
     */
    @ApiOperation("获取未分类的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "minPlay", value = "最低播放量", paramType = "query")
    })
    @GetMapping("/unclassified")
    public R getUnclassifiedVideos(String startDate, String endDate, Integer minPlay) {
        if (minPlay == null) {
            minPlay = 10000;
        }
        List<LinkedHashMap> result = videoDao.getUnclassified(startDate, endDate, minPlay);
        return R.ok().put("result", result);
    }

    /**
     * 获取已分类的视频
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param minPlay   最低播放量
     * @param gameId    游戏ID
     * @param search    搜索
     * @return 未分类的视频信息
     */
    @ApiOperation("获取已分类的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "minPlay", value = "最低播放量", paramType = "query"),
            @ApiImplicitParam(name = "gameId", value = "游戏ID", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "搜索", paramType = "query")
    })
    @GetMapping("/classified")
    public R getClassifiedVideos(String startDate, String endDate, Integer minPlay, String gameId, String search) {
        List<LinkedHashMap> result = videoDao.getClassified(startDate, endDate, minPlay, gameId, search);
        return R.ok().put("result", result);
    }

    /**
     * 显示标题dssq自动分类的结果
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 显示标题dssq自动分类的结果
     */
    @ApiOperation("显示标题dssq自动分类的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
    })
    @GetMapping("/showTitleDssq")
    public R showTitleDssq(String startDate, String endDate) {
        if (StringUtils.isBlank(startDate)) {
            return R.error();
        }
        Object result = dssqService.showTitleDssq(startDate, endDate);
        return R.ok().put("result", result);
    }

    /**
     * 自动添加标题dssq
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 自动添加标题dssq的结果
     */
    @ApiOperation("自动添加标题dssq")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query")
    })
    @PostMapping("/insertTitleDssq")
    public R insertTitleDssq(String startDate, String endDate) {
        if (StringUtils.isBlank(startDate)) {
            return R.error();
        }
        Object result = dssqService.insertTitleDssq(startDate, endDate);
        return R.ok().put("result", result);
    }

    /**
     * 获取未被分为dssq的视频
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 未被分为dssq的视频
     */
    @ApiOperation("获取未被分为dssq的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "updateDate", value = "视频更新开始日期", paramType = "query"),
            @ApiImplicitParam(name = "minPlay", value = "最低播放量", paramType = "query")
    })
    @GetMapping("/unclassifiedDssq")
    public R unclassifiedDssq(String startDate, String endDate, String updateDate, Integer minPlay) {
        if (minPlay == null) {
            minPlay = 3000;
        }
        if (minPlay < 3000) {
            return R.error();
        }
        List<VideoEntity> result = videoDao.getUnclassifiedDssq(startDate, endDate, updateDate, minPlay);
        return R.ok().put("result", result);
    }

    /**
     * 手动添加封面dssq
     *
     * @param aids aid数组
     * @return 手动添加封面dssq添加结果
     */
    @ApiOperation("手动添加封面dssq")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aids", value = "aid数组", required = true, paramType = "query"),
    })
    @PostMapping("/manualInsertCoverDssq")
    public R manualInsertCoverDssq(@RequestBody Long[] aids) {
        dssqDao.manualInsertDssq(aids, "cover");
        return R.ok();
    }

    /**
     * 添加标题dssq
     *
     * @param aids aid数组
     * @return 标题dssq添加结果
     */
    @ApiOperation("手动添加标题dssq")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aids", value = "aid数组", required = true, paramType = "query"),
    })
    @PostMapping("/manualInsertTitleDssq")
    public R manualInsertTitleDssq(@RequestBody Long[] aids) {
        dssqDao.manualInsertDssq(aids, "title");
        return R.ok();
    }
}
