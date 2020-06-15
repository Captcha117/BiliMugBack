package io.oken1.modules.mug.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.mug.service.CrawlerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Bilibili")
@RestController
@RequestMapping("spider")
public class CrawlerController {

    @Autowired
    CrawlerService crawlerService;

    /**
     * 分类视频信息
     *
     * @param pageCount 总页数
     * @return 视频信息
     */
    @ApiOperation("分类视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageCount", value = "总页数", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/CrawlVideoInfo", method = RequestMethod.GET)
    public R CrawlVideoInfo(int pageCount) {
        Object result = crawlerService.CrawlVideosByPage(pageCount);
        return R.ok().put("result", result);
    }
}
