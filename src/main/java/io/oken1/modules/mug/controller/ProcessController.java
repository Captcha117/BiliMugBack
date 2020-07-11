package io.oken1.modules.mug.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import io.oken1.common.utils.DateUtils;
import io.oken1.common.utils.R;
import io.oken1.modules.mug.dao.VideoDao;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.entity.VideoEntity;
import io.oken1.modules.mug.service.ContentService;
import io.oken1.modules.mug.service.DssqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "视频内容处理接口", tags = {"视频内容处理接口"})
@RestController
@RequestMapping("/mug/process")
public class ProcessController {
    @Autowired
    ContentService contentService;

    @Autowired
    DssqService dssqService;

    @Autowired
    VideoDao videoDao;

    /**
     * 视频根据游戏分类
     *
     * @return 分类结果
     */
    @ApiOperation("显示根据游戏分类的结果")
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
     * 视频根据游戏分类
     *
     * @return 分类结果
     */
    @ApiOperation("添加根据游戏分类的结果")
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
     * 更新视频内容
     *
     * @param aid        总页数
     * @param oldContent 旧内容
     * @param newType    新类型
     * @param newContent 新内容
     * @return 视频信息
     */
    @ApiOperation("更新视频内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aid", value = "视频AV号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "oldContent", value = "旧内容", paramType = "query"),
            @ApiImplicitParam(name = "newType", value = "新类型", required = true, paramType = "query"),
            @ApiImplicitParam(name = "newContent", value = "新内容", required = true, paramType = "query")
    })
    @PostMapping("/updateContent")
    public R updateContent(Long aid, String oldContent, String newType, String newContent) {
        if (StringUtils.isEmpty(oldContent) && StringUtils.isEmpty(newType)) {
            return R.error();
        }
        Object result = contentService.updateContent(aid, oldContent, newType, newContent);
        return R.ok().put("result", result);
    }

    /**
     * 批量更新视频内容
     *
     * @param contents 视频内容
     * @return 视频信息
     */
    @ApiOperation("批量更新视频内容")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contents", value = "视频内容", required = true, paramType = "query"),
    })
    @PostMapping("/updateContents")
    public R updateContents(@RequestBody String contents) {
        LinkedHashMap data = (LinkedHashMap) JSONUtils.parse(contents);
        JSONArray jsonArr = JSONArray.parseArray((String) data.get("contents"));
        List<ContentEntity> list = jsonArr.toJavaList(ContentEntity.class);

        Object result = contentService.saveOrUpdateBatch(list);
        return R.ok().put("result", result);
    }

    /**
     * 获取未分类的视频
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 视频信息
     */
    @ApiOperation("获取未分类的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
            @ApiImplicitParam(name = "minPlay", value = "最低播放量", required = true, paramType = "query")
    })
    @GetMapping("/unclassified")
    public R getUnclassifiedVideos(String startDate, String endDate, int minPlay) {
        List<VideoEntity> result = videoDao.getUnclassified(startDate, endDate, minPlay);
        return R.ok().put("result", result);
    }

    /**
     * 显示dssq分类的结果
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 显示dssq分类的结果
     */
    @ApiOperation("显示dssq分类的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query"),
    })
    @GetMapping("/showDssq")
    public R showDssq(String startDate, String endDate) {
        if (StringUtils.isBlank(startDate)) {
            return R.error();
        }
        Object result = dssqService.showDssq(startDate, endDate);
        return R.ok().put("result", result);
    }

    /**
     * 添加根据dssq分类的结果
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 分类添加结果
     */
    @ApiOperation("添加根据dssq分类的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", paramType = "query")
    })
    @PostMapping("/insertDssq")
    public R insertDssq(String startDate, String endDate) {
        if (StringUtils.isBlank(startDate)) {
            return R.error();
        }
        Object result = dssqService.insertDssq(startDate, endDate);
        return R.ok().put("result", result);
    }
}
