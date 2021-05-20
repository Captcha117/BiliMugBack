package io.oken1.modules.basic.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.basic.dao.CompanyDao;
import io.oken1.modules.basic.dao.NationDao;
import io.oken1.modules.basic.dao.SnsDao;
import io.oken1.modules.basic.dao.SnsTypeDao;
import io.oken1.modules.basic.entity.CompanyEntity;
import io.oken1.modules.basic.entity.NationEntity;
import io.oken1.modules.basic.entity.SnsEntity;
import io.oken1.modules.basic.entity.SnsTypeEntity;
import io.oken1.modules.basic.service.CompanyService;
import io.oken1.modules.basic.service.NationService;
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
        List<CompanyEntity> result = companyDao.getCompanyConfigList();
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

    @PostMapping("/snsType/save")
    public R snsTypeSave(@RequestBody SnsTypeEntity snsType) {
        snsTypeService.save(snsType);
        return R.ok();
    }

    @PostMapping("/snsType/update")
    public R snsTypeUpdate(@RequestBody SnsTypeEntity snsType) {
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
    NationService nationService;
    @Autowired
    NationDao nationDao;

    @RequestMapping("/nation/list")
    public R nationList() {
        List<NationEntity> result = nationDao.getNationConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/nation/info/{nation}")
    //@RequiresPermissions("mug:mug:info")
    public R nationInfo(@PathVariable("nation") String nation) {
        NationEntity nationEntity = nationService.getById(nation);
        return R.ok().put("nationInfo", nationEntity);
    }

    @PostMapping("/nation/save")
    public R nationSave(@RequestBody NationEntity nation) {
        nationService.save(nation);
        return R.ok();
    }

    @PostMapping("/nation/update")
    public R nationUpdate(@RequestBody NationEntity nation) {
        nationService.updateById(nation);
        return R.ok();
    }

    @PostMapping("/nation/delete")
    public R nationDelete(@RequestBody String[] nationIds) {
        nationService.removeByIds(Arrays.asList(nationIds));

        return R.ok();
    }
    //endregion
}
