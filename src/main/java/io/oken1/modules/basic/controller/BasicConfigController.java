package io.oken1.modules.basic.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.basic.dao.CompanyDao;
import io.oken1.modules.basic.dao.RegionDao;
import io.oken1.modules.basic.dao.SnsDao;
import io.oken1.modules.basic.dao.SnsTypeDao;
import io.oken1.modules.basic.entity.CompanyEntity;
import io.oken1.modules.basic.entity.RegionEntity;
import io.oken1.modules.basic.entity.SnsEntity;
import io.oken1.modules.basic.entity.SnsTypeEntity;
import io.oken1.modules.basic.service.CompanyService;
import io.oken1.modules.basic.service.RegionService;
import io.oken1.modules.basic.service.SnsService;
import io.oken1.modules.basic.service.SnsTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "基础数据配置", tags = {"基础数据配置"})
@RestController
@RequestMapping("/config")
public class BasicConfigController {
    //region mug_company
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyDao companyDao;

    @RequestMapping("/company/list")
    public R companyList() {
        List<LinkedHashMap> result = companyDao.getCompanyConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/company/info/{companyId}")
    //@RequiresPermissions("mug:mug:info")
    public R companyInfo(@PathVariable("companyId") String companyId) {
        CompanyEntity company = companyService.getById(companyId);
        return R.ok().put("companyInfo", company);
    }

    @PostMapping("/company/save")
    public R companySave(@RequestBody CompanyEntity company) {
        companyService.save(company);
        return R.ok();
    }

    @PostMapping("/company/update")
    public R companyUpdate(@RequestBody CompanyEntity company) {
        companyService.updateById(company);
        return R.ok();
    }

    @PostMapping("/company/delete")
    public R companyDelete(@RequestBody String[] companyIds) {
        companyService.removeByIds(Arrays.asList(companyIds));

        return R.ok();
    }
    //endregion

    //region tb_sns_type
    @Autowired
    SnsTypeService snsTypeService;
    @Autowired
    SnsTypeDao snsTypeDao;

    @RequestMapping("/snsType/list")
    public R snsTypeList() {
        List<SnsTypeEntity> result = snsTypeDao.getSnsTypeConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/snsType/info/{snsType}")
    //@RequiresPermissions("mug:mug:info")
    public R snsTypeInfo(@PathVariable("snsType") String snsType) {
        SnsTypeEntity snsTypeEntity = snsTypeService.getById(snsType);
        return R.ok().put("snsTypeInfo", snsTypeEntity);
    }

    @PostMapping("/snsType/save/{increase}")
    public R snsTypeSave(@RequestBody SnsTypeEntity snsType, @PathVariable Boolean increase) {
        snsTypeService.save(snsType);
        return R.ok();
    }

    @PostMapping("/snsType/update/{increase}")
    public R snsTypeUpdate(@RequestBody SnsTypeEntity snsType, @PathVariable Boolean increase) {
        snsTypeService.updateById(snsType);
        return R.ok();
    }

    @PostMapping("/snsType/delete")
    public R snsTypeDelete(@RequestBody String[] snsTypeIds) {
        snsTypeService.removeByIds(Arrays.asList(snsTypeIds));

        return R.ok();
    }
    //endregion

    //region mug_sns
    @Autowired
    SnsService snsService;
    @Autowired
    SnsDao snsDao;

    @RequestMapping("/sns/list")
    public R snsList() {
        List<LinkedHashMap> result = snsDao.getSnsConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/sns/info/{sns}")
    //@RequiresPermissions("mug:mug:info")
    public R snsInfo(@PathVariable("sns") String sns) {
        SnsEntity snsEntity = snsService.getById(sns);
        return R.ok().put("snsInfo", snsEntity);
    }

    @PostMapping("/sns/save")
    public R snsSave(@RequestBody SnsEntity sns) {
        snsService.save(sns);
        return R.ok();
    }

    @PostMapping("/sns/update")
    public R snsUpdate(@RequestBody SnsEntity sns) {
        snsService.updateById(sns);
        return R.ok();
    }

    @PostMapping("/sns/delete")
    public R snsDelete(@RequestBody String[] snsIds) {
        snsService.removeByIds(Arrays.asList(snsIds));

        return R.ok();
    }
    //endregion

    //region tb_region
    @Autowired
    RegionService regionService;
    @Autowired
    RegionDao regionDao;

    @RequestMapping("/region/list")
    public R regionList() {
        List<RegionEntity> result = regionDao.getRegionConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/region/info/{region}")
    //@RequiresPermissions("mug:mug:info")
    public R regionInfo(@PathVariable("region") String region) {
        RegionEntity regionEntity = regionService.getById(region);
        return R.ok().put("regionInfo", regionEntity);
    }

    @PostMapping("/region/save")
    public R regionSave(@RequestBody RegionEntity region) {
        regionService.save(region);
        return R.ok();
    }

    @PostMapping("/region/update")
    public R regionUpdate(@RequestBody RegionEntity region) {
        regionService.updateById(region);
        return R.ok();
    }

    @PostMapping("/region/delete")
    public R regionDelete(@RequestBody String[] regionIds) {
        regionService.removeByIds(Arrays.asList(regionIds));

        return R.ok();
    }
    //endregion
}
