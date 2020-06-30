package io.oken1.modules.mug.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.mug.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(value = "视频内容接口", tags = {"视频内容接口"})
@RestController
@RequestMapping("/mug/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    /**
     * 视频根据游戏分类
     *
     * @return 分类结果
     */
    @ApiOperation("显示根据游戏分类的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
    })
    @GetMapping("/gameContent")
    public R gameContent(String startDate) {
        Object result = contentService.gameContent(startDate);
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
    })
    @GetMapping("/insertGameContent")
    public R insertGameContent(String startDate) {
        Object result = contentService.insertGameContent(startDate);
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
            @ApiImplicitParam(name = "newType", value = "新类型", paramType = "query"),
            @ApiImplicitParam(name = "newContent", value = "新内容", required = true, paramType = "query")
    })
    @GetMapping("/crawlVideosByPage")
    public R updateComment(String aid, String oldContent, String newType, String newContent) {
        if (StringUtils.isEmpty(oldContent) && StringUtils.isEmpty(newType)) {
            return R.error();
        }
        Object result = contentService.updateContent(aid, oldContent, newType, newContent);
        return R.ok().put("result", result);
    }
}
