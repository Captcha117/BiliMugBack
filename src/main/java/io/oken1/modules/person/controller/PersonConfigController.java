package io.oken1.modules.person.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.person.dao.GroupDao;
import io.oken1.modules.person.dao.PersonDao;
import io.oken1.modules.person.dao.UploaderDao;
import io.oken1.modules.person.entity.GroupEntity;
import io.oken1.modules.person.entity.PersonEntity;
import io.oken1.modules.person.entity.UploaderEntity;
import io.oken1.modules.person.service.GroupService;
import io.oken1.modules.person.service.PersonService;
import io.oken1.modules.person.service.UploaderService;
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

    //region mug_uploader
    @Autowired
    UploaderService uploaderService;
    @Autowired
    UploaderDao uploaderDao;

    @GetMapping("/uploader/list")
    //@RequiresPermissions("mug:mug:list")
    public R uploaderList() {
        List<LinkedHashMap> uploaderList = uploaderDao.getUploaderConfigList();
        return R.ok().put("uploaderList", uploaderList);
    }

    @GetMapping("/uploader/info/{uploaderId}")
    public R uploaderInfo(@PathVariable("uploaderId") String uploaderId) {
        UploaderEntity uploaderEntity = uploaderService.getById(uploaderId);
        return R.ok().put("uploaderInfo", uploaderEntity);
    }

    @PostMapping("/uploader/save")
    public R uploaderSave(@RequestBody UploaderEntity uploaderEntity) {
        uploaderService.save(uploaderEntity);
        return R.ok();
    }

    @PostMapping("/uploader/update")
    public R uploaderUpdate(@RequestBody UploaderEntity uploaderEntity) {
        uploaderService.updateById(uploaderEntity);
        return R.ok();
    }

    @PostMapping("/uploader/delete")
    public R uploaderDelete(@RequestBody String[] uploaderIds) {
        uploaderService.removeByIds(Arrays.asList(uploaderIds));

        return R.ok();
    }

    @GetMapping("/uploader/search/{search}")
    public R uploaderSearch(@PathVariable("search") String search) {
        List<LinkedHashMap> uploaderList = uploaderDao.searchUploader(search);
        return R.ok().put("uploaderList", uploaderList);
    }
    //endregion

    //region mug_group
    @Autowired
    GroupService groupService;
    @Autowired
    GroupDao groupDao;

    @GetMapping("/group/list")
    //@RequiresPermissions("mug:mug:list")
    public R groupList() {
        List<LinkedHashMap> groupList = groupDao.getGroupConfigList();
        return R.ok().put("groupList", groupList);
    }

    @GetMapping("/group/info/{groupId}")
    public R groupInfo(@PathVariable("groupId") String groupId) {
        GroupEntity groupEntity = groupService.getById(groupId);
        return R.ok().put("groupInfo", groupEntity);
    }

    @PostMapping("/group/save")
    public R groupSave(@RequestBody GroupEntity groupEntity) {
        groupService.save(groupEntity);
        return R.ok();
    }

    @PostMapping("/group/update")
    public R groupUpdate(@RequestBody GroupEntity groupEntity) {
        groupService.updateById(groupEntity);
        return R.ok();
    }

    @PostMapping("/group/delete")
    public R groupDelete(@RequestBody String[] groupIds) {
        groupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }

    @GetMapping("/group/search/{search}")
    public R groupSearch(@PathVariable("search") String search) {
        List<LinkedHashMap> groupList = groupDao.searchGroup(search);
        return R.ok().put("groupList", groupList);
    }
    //endregion

    //region mug_group_member
    //endregion
}
