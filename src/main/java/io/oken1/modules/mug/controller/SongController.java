package io.oken1.modules.mug.controller;

import java.util.LinkedHashMap;
import java.util.List;

import io.oken1.modules.mug.service.SongService;
import io.oken1.modules.mug.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.oken1.common.utils.R;


@RestController
@RequestMapping("song")
public class SongController {
    @Autowired
    private SongService songService;

    @RequestMapping("/getSongInfo")
    public R getSongInfo(@RequestParam String songId) {
        Object result = songService.getSongInfo(songId);
        return R.ok().put("gameInfo", result);
    }
}
