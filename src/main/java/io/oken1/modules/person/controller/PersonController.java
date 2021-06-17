package io.oken1.modules.person.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.person.dao.PersonDao;
import io.oken1.modules.person.entity.PersonEntity;
import io.oken1.modules.person.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@Api(value = "人物", tags = {"人物"})
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @Autowired
    PersonDao personDao;

    @ApiOperation("曲目艺术家标签化")
    @GetMapping("/processSongArtist")
    public R processSongArtist(@RequestParam String gameId) {
        if (StringUtils.isBlank(gameId)) {
            return R.error();
        }
        personService.processSongArtist(gameId);
        return R.ok();
    }

    @ApiOperation("获取人物基本信息")
    @GetMapping("/getPersonInfo")
    public R getPersonInfo(String personId) {
        PersonEntity personEntity = personService.getById(personId);
        return R.ok().put("personInfo", personEntity);
    }

    @ApiOperation("获取人物游戏相关信息")
    @GetMapping("/getRelatedInfoByPersonId")
    public R getRelatedInfoByPersonId(String personId) {
        List<LinkedHashMap> gameList = personDao.getPersonGameByPersonId(personId);
        List<LinkedHashMap> songList = personDao.getPersonSongByPersonId(personId);
        List<LinkedHashMap> singleList = personDao.getPersonSingleByPersonId(personId);
        return R.ok().put("gameList", gameList).put("songList", songList).put("singleList", singleList);
    }
}
