package io.oken1.modules.music.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.music.dao.SingleDao;
import io.oken1.modules.music.dao.SongDao;
import io.oken1.modules.music.entity.SingleEntity;
import io.oken1.modules.music.entity.SongEntity;
import io.oken1.modules.music.service.SingleService;
import io.oken1.modules.music.service.SongService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


@Api(value = "音乐", tags = {"音乐"})
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
        List<SongEntity> result = songDao.getBriefSongListByGameId(gameId);
        return R.ok().put("result", result);
    }

    @GetMapping("/song/info/{songId}")
    public R songInfo(@PathVariable("songId") String songId) {
        SongEntity songEntity = songService.getById(songId);
        return R.ok().put("songInfo", songEntity);
    }

    @PostMapping("/song/save")
    public R songSave(@RequestBody SongEntity songEntity) {
        songService.save(songEntity);
        return R.ok();
    }

    @PostMapping("/song/update")
    public R songUpdate(@RequestBody SongEntity songEntity) {
        songService.updateById(songEntity);
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
        List<SingleEntity> result = singleService.list();
        return R.ok().put("result", result);
    }

    @GetMapping("/single/info/{singleId}")
    public R singleInfo(@PathVariable("singleId") String singleId) {
        SingleEntity singleEntity = singleService.getById(singleId);
        return R.ok().put("singleInfo", singleEntity);
    }

    @PostMapping("/single/save")
    public R singleSave(@RequestBody SingleEntity singleEntity) {
        singleService.save(singleEntity);
        return R.ok();
    }

    @PostMapping("/single/update")
    public R singleUpdate(@RequestBody SingleEntity singleEntity) {
        singleService.updateById(singleEntity);
        return R.ok();
    }

    @PostMapping("/single/delete")
    public R singleDelete(@RequestBody String[] singleIds) {
        singleService.removeByIds(Arrays.asList(singleIds));

        return R.ok();
    }
    //endregion
}
