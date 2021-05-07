package io.oken1.modules.basic.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.basic.dao.CompanyDao;
import io.oken1.modules.basic.entity.CompanyEntity;
import io.oken1.modules.basic.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(value = "公司", tags = {"公司"})
@RestController
@RequestMapping("/config")
public class BasicConfigController {
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyDao companyDao;

    //region mug_company
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
    //@RequiresPermissions("mug:mug:save")
    public R companySave(@RequestBody CompanyEntity company) {
        companyService.save(company);
        return R.ok();
    }

    @PostMapping("/company/update")
    //@RequiresPermissions("mug:mug:update")
    public R companyUpdate(@RequestBody CompanyEntity company) {
        companyService.updateById(company);
        return R.ok();
    }

    @PostMapping("/company/delete")
    //@RequiresPermissions("mug:mug:delete")
    public R companyDelete(@RequestBody String[] companyIds) {
        companyService.removeByIds(Arrays.asList(companyIds));

        return R.ok();
    }
    //endregion
}
