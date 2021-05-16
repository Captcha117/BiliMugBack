package io.oken1.modules.person.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.person.dao.PersonDao;
import io.oken1.modules.person.entity.PersonEntity;
import io.oken1.modules.person.service.PersonService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "人物数据配置", tags = {"人物数据配置"})
@RestController
@RequestMapping("/config")
public class PersonConfigController {
    //region mug_person
    @Autowired
    PersonService personService;
    @Autowired
    PersonDao personDao;

    @GetMapping("/person/list")
    //@RequiresPermissions("mug:mug:list")
    public R personList() {
        List<LinkedHashMap> personList = personDao.getPersonConfigList();
        return R.ok().put("personList", personList);
    }

    @GetMapping("/person/info/{personId}")
    public R personInfo(@PathVariable("personId") String personId) {
        PersonEntity personEntity = personService.getById(personId);
        return R.ok().put("personInfo", personEntity);
    }

    @PostMapping("/person/save")
    public R personSave(@RequestBody PersonEntity personEntity) {
        personService.save(personEntity);
        return R.ok();
    }

    @PostMapping("/person/update")
    public R personUpdate(@RequestBody PersonEntity personEntity) {
        personService.updateById(personEntity);
        return R.ok();
    }

    @PostMapping("/person/delete")
    public R personDelete(@RequestBody String[] personIds) {
        personService.removeByIds(Arrays.asList(personIds));

        return R.ok();
    }

    @GetMapping("/person/search/{search}")
    public R singleSearch(@PathVariable("search") String search) {
        List<LinkedHashMap> personList = personDao.searchPerson(search);
        return R.ok().put("personList", personList);
    }
    //endregion
}
