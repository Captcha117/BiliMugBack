package io.oken1.modules.music.controller;

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

import io.oken1.common.utils.R;


@Api(value = "音乐", tags = {"音乐"})
@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

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
