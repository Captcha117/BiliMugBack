package io.oken1.modules.mug.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.mug.dao.BasicDao;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "基础数据接口", tags = {"基础数据接口"})
@RestController
@RequestMapping("/mug/basic")
public class BasicController {
    @Autowired
    BasicDao basicDao;

    /**
     * 获取SNS信息表
     *
     * @return SNS信息表
     */
    @GetMapping("/snsList")
    public R getSnsList() {
        List<LinkedHashMap> result = basicDao.getSnsList();
        return R.ok().put("snsList", result);
    }
}