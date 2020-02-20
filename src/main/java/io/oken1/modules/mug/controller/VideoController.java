package io.oken1.modules.mug.controller;

import java.util.LinkedHashMap;
import java.util.List;

import io.oken1.modules.mug.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.oken1.common.utils.R;


@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getVideosByGameId")
    public R getVideosByGameId(@RequestParam String gameId) {
        List<LinkedHashMap> videoList = videoService.getVideosByGameId(gameId);
        videoList = videoList.subList(0, Math.min(videoList.size(), 20));
        return R.ok().put("videoList", videoList);
    }

    @RequestMapping("/getVideosBySongId")
    public R getVideosBySongId(@RequestParam String songId) {
        List<LinkedHashMap> videoList = videoService.getVideosBySongId(songId);
        videoList = videoList.subList(0, Math.min(videoList.size(), 20));
        return R.ok().put("videoList", videoList);
    }
}
