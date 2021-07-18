package io.oken1.modules.music.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.music.dao.SingleDao;
import io.oken1.modules.music.dao.SingleRelationDao;
import io.oken1.modules.music.dao.SongDao;
import io.oken1.modules.music.entity.SingleEntity;
import io.oken1.modules.music.entity.SingleRelationEntity;
import io.oken1.modules.music.entity.SongEntity;
import io.oken1.modules.music.service.SingleRelationService;
import io.oken1.modules.music.service.SingleService;
import io.oken1.modules.music.service.SongService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


@Api(value = "音乐数据配置", tags = {"音乐数据配置"})
@RestController
@RequestMapping("/config")
public class MusicConfigController {
    //region mug_song
    @Autowired
    SongService songService;
    @Autowired
    SongDao songDao;

    @GetMapping("/song/list")
    //@RequiresPermissions("mug:mug:list")
    public R songList() {
        List<LinkedHashMap> result = songDao.getSongConfigList();
        return R.ok().put("result", result);
    }

    @GetMapping("/song/list/{gameId}")
    //@RequiresPermissions("mug:mug:list")
    public R songListByGameId(@PathVariable("gameId") String gameId) {
        List<LinkedHashMap> result = songDao.getSongConfigListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/song/info/{songId}")
    public R songInfo(@PathVariable("songId") String songId) {
        SongEntity songEntity = songService.getById(songId);
        return R.ok().put("songInfo", songEntity);
    }

    @PostMapping("/song/saveOrUpdate")
    public R songSaveOrUpdate(@RequestBody SongEntity songEntity) {
        songService.saveOrUpdate(songEntity);
        return R.ok();
    }

    @PostMapping("/song/delete")
    public R songDelete(@RequestBody String[] songIds) {
        songService.removeByIds(Arrays.asList(songIds));

        return R.ok();
    }
    //endregion

    //region mug_single
    @Autowired
    SingleService singleService;
    @Autowired
    SingleDao singleDao;

    @GetMapping("/single/list")
    //@RequiresPermissions("mug:mug:list")
    public R singleList() {
        List<SingleEntity> singleList = singleDao.getSingleList();
        return R.ok().put("singleList", singleList);
    }

    @GetMapping("/single/info/{singleId}")
    public R singleInfo(@PathVariable("singleId") String singleId) {
        SingleEntity singleEntity = singleService.getById(singleId);
        return R.ok().put("singleInfo", singleEntity);
    }

    @PostMapping("/single/saveOrUpdate")
    public R singleSaveOrUpdate(@RequestBody SingleEntity singleEntity) {
        singleService.saveOrUpdate(singleEntity);
        return R.ok();
    }

    @PostMapping("/single/delete")
    public R singleDelete(@RequestBody String[] singleIds) {
        singleService.removeByIds(Arrays.asList(singleIds));

        return R.ok();
    }

    @GetMapping("/single/search/{search}")
    public R singleSearch(@PathVariable("search") String search) {
        List<SingleEntity> singleList = singleDao.searchSingle(search);
        return R.ok().put("singleList", singleList);
    }

    @Autowired
    SingleRelationService singleRelationService;
    @Autowired
    SingleRelationDao singleRelationDao;

    @GetMapping("/singleRelation/info/{singleId}")
    public R singleRelationInfo(@PathVariable("singleId") String singleId) {
        List<LinkedHashMap> singleRelationList = singleRelationDao.getSingleRelationListBySingleId(singleId);
        return R.ok().put("singleRelationList", singleRelationList);
    }

    @PostMapping("/singleRelation/save")
    public R singleRelationSave(@RequestBody SingleRelationEntity singleRelationEntity) {
        singleRelationService.save(singleRelationEntity);
        return R.ok();
    }

    @PostMapping("/singleRelation/update")
    public R singleRelationUpdate(@RequestBody SingleRelationEntity singleRelationEntity) {
        singleRelationService.updateById(singleRelationEntity);
        return R.ok();
    }

    @PostMapping("/singleRelation/delete")
    public R singleRelationDelete(@RequestBody String[] singleRelationIds) {
        singleRelationService.removeByIds(Arrays.asList(singleRelationIds));

        return R.ok();
    }


    //endregion
}
