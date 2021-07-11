package io.oken1.modules.video.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import io.oken1.common.utils.R;
import io.oken1.modules.video.dao.ContentDao;
import io.oken1.modules.video.dao.DssqDao;
import io.oken1.modules.video.dao.VideoDao;
import io.oken1.modules.video.entity.GameContentEntity;
import io.oken1.modules.video.service.ContentService;
import io.oken1.modules.video.service.DssqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Autowired
    ContentDao contentDao;

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
     * 获取进行游戏分类的视频
     *
     * @param startDate  开始日期
     * @param endDate    结束日期
     * @param minPlay    最低播放量
     * @param gameId     游戏ID
     * @param search     搜索
     * @param isClassify 是否已分类
     * @return 进行游戏分类的视频
     */
    @ApiOperation("获取进行游戏分类的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "minPlay", value = "最低播放量", paramType = "query"),
            @ApiImplicitParam(name = "gameId", value = "游戏ID", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "搜索", paramType = "query"),
            @ApiImplicitParam(name = "isClassify", value = "是否已分类", paramType = "query")
    })
    @GetMapping("/getVideoListToClassify")
    public R getClassifiedVideos(String startDate, String endDate, Integer minPlay, String gameId, String search, Boolean isClassify) {
        if (minPlay == null) {
            minPlay = 10000;
        }
        List<LinkedHashMap> result = videoDao.getProcessVideoList(startDate, endDate, minPlay, gameId, search, isClassify, null);
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
    @PostMapping("/updateGameContentBatch/{delete}")
    public R updateGameContentBatch(@RequestBody String contents, @PathVariable("delete") Boolean delete) {
        LinkedHashMap data = (LinkedHashMap) JSONUtils.parse(contents);
        JSONArray jsonArr = JSONArray.parseArray((String) data.get("contents"));
        List<GameContentEntity> list = jsonArr.toJavaList(GameContentEntity.class);
        if (delete) {
            ArrayList<Long> deleteAids = new ArrayList<>();
            for (GameContentEntity c : list) {
                deleteAids.add(c.getAid());
            }
            if (deleteAids.size() > 0) {
                contentDao.deleteContentByAids(deleteAids);
            }
        }
        Object result = contentService.saveOrUpdateBatch(list);
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
     * 获取进行dssq分类的视频
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param minPlay   最低播放量
     * @param gameId    游戏ID
     * @param search    搜索
     * @param isDssq    是否是dssq
     * @return 进行dssq分类的视频
     */
    @ApiOperation("获取进行dssq分类的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "minPlay", value = "最低播放量", paramType = "query"),
            @ApiImplicitParam(name = "gameId", value = "游戏ID", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "搜索", paramType = "query"),
            @ApiImplicitParam(name = "isClassify", value = "是否是dssq", paramType = "query")
    })
    @GetMapping("/getVideoListToDssq")
    public R getVideoListToDssq(String startDate, String endDate, Integer minPlay, String gameId, String search, Boolean isDssq) {
        if (minPlay == null) {
            minPlay = 3000;
        }
        List<LinkedHashMap> result = videoDao.getProcessVideoList(startDate, endDate, minPlay, gameId, search, null, isDssq);
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

    /**
     * 删除dssq
     *
     * @param aids aid数组
     */
    @ApiOperation("删除dssq")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aids", value = "aid数组", required = true, paramType = "query"),
    })
    @PostMapping("/removeDssq")
    public R removeDssq(@RequestBody Long[] aids) {
        dssqDao.removeDssq(aids);
        return R.ok();
    }
}
