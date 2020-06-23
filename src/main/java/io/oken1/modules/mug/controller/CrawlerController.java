package io.oken1.modules.mug.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.mug.service.CrawlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        if (pageCount < 1) {
            return R.error();
        }
        Object result = crawlerService.crawlVideosByPage(pageCount);
        return R.ok().put("result", result);
    }

    /**
     * 批量视频信息
     *
     * @param startPage 开始页数
     * @param endPage   结束页数
     * @return 视频信息
     */
    @ApiOperation("批量视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startPage", value = "开始页数", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endPage", value = "结束页数", required = true, paramType = "query"),
    })
    @GetMapping("/crawlVideosByPages")
    public R crawlVideosByPage(int startPage, int endPage) {
        if (startPage > endPage) {
            return R.error();
        }
        Object result = crawlerService.crawlVideosByPage(startPage, endPage);
        return R.ok().put("result", result);
    }

    /**
     * 根据AV号或BV号获取视频信息
     *
     * @param id 总页数
     * @return 视频信息
     */
    @ApiOperation("根据AV号或BV号获取视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "aid/bvid", required = true, paramType = "query"),
    })
    @GetMapping(value = "/crawlVideosById")
    public R crawlVideoById(String id) {
        Object result = crawlerService.crawlVideoById(id);
        return R.ok().put("result", result);
    }

    /**
     * 获取UP主信息
     *
     * @param id 总页数
     * @return 视频信息
     */
    @ApiOperation("获取UP主信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "mid", required = true, paramType = "query"),
    })
    @GetMapping(value = "/crawlUploaderById")
    public R crawlUploaderById(String id) {
        Object result = crawlerService.crawlUploaderById(id);
        return R.ok().put("result", result);
    }
}
