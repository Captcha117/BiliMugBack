package io.oken1.modules.mug.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.mug.service.CrawlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "爬虫接口", tags = {"爬虫接口"})
@RestController
@RequestMapping("/mug/crawler")
public class CrawlerController {

    @Autowired
    CrawlerService crawlerService;

    /**
     * 批量视频信息
     *
     * @param pageCount 总页数
     * @return 视频信息
     */
    @ApiOperation("批量视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageCount", value = "总页数", required = true, paramType = "query"),
    })
    @GetMapping("/crawlVideosByPage")
    public R crawlVideosByPage(int pageCount) {
        Object result = crawlerService.crawlVideosByPage(pageCount);
        return R.ok().put("result", result);
    }

    /**
     * 批量视频信息
     *
     * @param id 总页数
     * @return 视频信息
     */
    @ApiOperation("根据AV号或BV号获取视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "aid/bid", required = true, paramType = "query"),
    })
    @GetMapping(value = "/crawlVideosById")
    public R crawlVideoById(String id)
    {
        return R.ok();
    }
}
