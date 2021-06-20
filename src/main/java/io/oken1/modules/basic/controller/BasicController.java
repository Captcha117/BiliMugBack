package io.oken1.modules.basic.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.basic.dao.BasicDao;
import io.oken1.modules.game.entity.DifficultyEntity;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "基础数据", tags = {"基础数据"})
@RestController
@RequestMapping("/basic")
public class BasicController {
    @Autowired
    BasicDao basicDao;

    /**
     * 获取SNS信息表
     *
     * @return SNS信息表
     */
    @GetMapping("/allSnsList")
    public R getAllSnsList() {
        List<LinkedHashMap> result = basicDao.getAllSnsList();
        return R.ok().put("allSnsList", result);
    }

    /**
     * 获取公司信息表
     *
     * @return 公司信息表
     */
    @GetMapping("/getCompanyList")
    public R getCompanyList() {
        List<LinkedHashMap> result = basicDao.getCompanyList();
        return R.ok().put("companyList", result);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        return R.ok();
    }

    /**
     * 全局搜索
     *
     * @param search 关键词
     * @return 搜索结果
     */
    @GetMapping("/globalSearch")
    public R globalSearch(String search) {
        if (StringUtils.isBlank(search) || search.length() < 2) {
            return R.error();
        }
        List<LinkedHashMap> gameList = basicDao.searchGame(search);
        List<LinkedHashMap> singleList = basicDao.searchSingle(search);
        List<LinkedHashMap> personList = basicDao.searchPerson(search);
        List<LinkedHashMap> uploaderList = basicDao.searchUploader(search);
        List<LinkedHashMap> videoList = basicDao.searchVideo(search);
        return R.ok().put("gameList", gameList).put("singleList", singleList)
                .put("personList", personList).put("uploaderList", uploaderList)
                .put("videoList", videoList);
    }
}
