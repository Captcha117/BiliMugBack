package io.oken1.modules.music.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.game.model.GameModel;
import io.oken1.modules.music.dao.SingleDao;
import io.oken1.modules.music.entity.SingleEntity;
import io.oken1.modules.music.service.SingleService;
import io.oken1.modules.music.service.SongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;


@Api(value = "音乐", tags = {"音乐"})
@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired
    SongService songService;

    @Autowired
    SingleService singleService;

    @Autowired
    SingleDao singleDao;

    @ApiOperation("获取UP主基本信息")
    @GetMapping("/getSingleInfoBySingleId")
    public R getSingleInfoBySingleId(String singleId) {
        SingleEntity singleEntity = singleService.getById(singleId);
        return R.ok().put("singleInfo", singleEntity);
    }

    @ApiOperation("获取UP主相关信息")
    @GetMapping("/getSingleRelatedInfoBySingleId")
    public R getSingleRelatedInfoBySingleId(String singleId) {
        List<GameModel> gameList = singleDao.getSingleGameBySingleId(singleId);
        List<LinkedHashMap> songList = singleDao.getSingleSongBySingleId(singleId);
        return R.ok().put("gameList", gameList).put("songList", songList);
    }

    @ApiOperation("曲目信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "songId", value = "曲目ID", required = true, paramType = "query"),
    })
    @GetMapping("/getSongInfo")
    public R getSongInfo(@RequestParam String songId) {
        Object result = songService.getSongInfo(songId);
        return R.ok().put("gameInfo", result);
    }
}
