package io.oken1.modules.person.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.person.dao.PersonDao;
import io.oken1.modules.person.dao.UploaderDao;
import io.oken1.modules.person.entity.PersonEntity;
import io.oken1.modules.person.entity.UploaderEntity;
import io.oken1.modules.person.service.PersonService;
import io.oken1.modules.person.service.UploaderService;
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

    @Autowired
    UploaderService uploaderService;

    @Autowired
    UploaderDao uploaderDao;

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
    @GetMapping("/getArtistInfoByPersonId")
    public R getArtistInfoByPersonId(String personId) {
        PersonEntity personEntity = personService.getById(personId);
        return R.ok().put("artistInfo", personEntity);
    }

    @ApiOperation("获取人物游戏相关信息")
    @GetMapping("/getArtistRelatedInfoByPersonId")
    public R getArtistRelatedInfoByPersonId(String personId) {
        List<LinkedHashMap> gameList = personDao.getPersonGameByPersonId(personId);
        List<LinkedHashMap> songList = personDao.getPersonSongByPersonId(personId);
        List<LinkedHashMap> singleList = personDao.getPersonSingleByPersonId(personId);
        return R.ok().put("gameList", gameList).put("songList", songList).put("singleList", singleList);
    }

    @ApiOperation("获取UP主基本信息")
    @GetMapping("/getUploaderInfoByUid")
    public R getUploaderInfoByUid(Long uid) {
        UploaderEntity uploaderEntity = uploaderService.getById(uid);
        LinkedHashMap rankInfo = uploaderDao.getUploaderRankByUid(uid);
        return R.ok().put("uploaderInfo", uploaderEntity).put("rankInfo", rankInfo);
    }

    @ApiOperation("获取UP主相关信息")
    @GetMapping("/getUploaderRelatedInfoByUid")
    public R getUploaderRelatedInfoByUid(Long uid) {
        List<LinkedHashMap> videoList = uploaderDao.getUploaderVideoByUid(uid);
        List<LinkedHashMap> gameList = uploaderDao.getUploaderGameByUid(uid);
        return R.ok().put("videoList", videoList).put("gameList", gameList);
    }
}
