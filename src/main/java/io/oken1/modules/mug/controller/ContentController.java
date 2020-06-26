package io.oken1.modules.mug.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.mug.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/gameContent")
    public R gameContent() {
        Object result = contentService.gameContent();
        return R.ok().put("result", result);
    }

    /**
     * 视频根据游戏分类
     *
     * @return 分类结果
     */
    @ApiOperation("添加根据游戏分类的结果")
    @GetMapping("/insertGameContent")
    public R insertGameContent() {
        Object result = contentService.insertGameContent();
        return R.ok().put("result", result);
    }
}
