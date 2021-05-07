package io.oken1.modules.crawl.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.crawl.service.CrawlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "爬虫", tags = {"爬虫"})
@RestController
@RequestMapping("/crawl")
public class CrawlController {

    @Autowired
    CrawlService crawlService;

    /**
     * 爬取第1~endPage页的视频信息
     *
     * @param endPage 总页数
     * @return 视频信息爬取结果
     */
    @ApiOperation("爬取第1~endPage页的视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "endPage", value = "总页数", required = true, paramType = "query"),
    })
    @GetMapping("/crawlVideosByPage")
    public R crawlVideosByPage(int endPage) {
        if (endPage < 1) {
            return R.error();
        }
        Object result = crawlService.crawlVideosByPage(endPage);
        return R.ok().put("result", result);
    }

    /**
     * 爬取第startPage~endPage页的视频信息
     *
     * @param startPage 开始页数
     * @param endPage   结束页数
     * @return 视频信息爬取结果
     */
    @ApiOperation("爬取第startPage~endPage页的视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startPage", value = "开始页数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endPage", value = "结束页数", required = true, paramType = "query"),
    })
    @GetMapping("/crawlVideosByPages")
    public R crawlVideosByPage(int startPage, int endPage) {
        if (startPage > endPage) {
            return R.error();
        }
        Object result = crawlService.crawlVideosByPage(startPage, endPage);
        return R.ok().put("result", result);
    }

    /**
     * 根据AV号或BV号爬取视频信息
     *
     * @param id 视频ID
     * @return 视频信息爬取结果
     */
    @ApiOperation("根据AV号或BV号获取视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "aid/bvid", required = true, paramType = "query"),
    })
    @GetMapping(value = "/crawlVideosById")
    public R crawlVideoById(String id) {
        Object result = crawlService.crawlVideoById(id);
        return R.ok().put("result", result);
    }

    /**
     * 根据ID爬取UP主信息
     *
     * @param id UP主ID
     * @return UP主信息爬取结果
     */
    @ApiOperation("获取UP主信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "mid", required = true, paramType = "query"),
    })
    @GetMapping(value = "/crawlUploaderById")
    public R crawlUploaderById(String id) {
        Object result = crawlService.crawlUploaderById(id);
        return R.ok().put("result", result);
    }
}
