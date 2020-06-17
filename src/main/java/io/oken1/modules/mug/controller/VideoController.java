package io.oken1.modules.mug.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import io.oken1.modules.mug.dao.VideoDao;
import io.oken1.modules.mug.service.VideoService;
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


@Api(value = "视频接口", tags = {"视频接口"})
@RestController
@RequestMapping("/mug/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @Autowired
    VideoDao videoDao;

    @GetMapping("/getVideosByGameId")
    @ApiOperation("根据游戏id获取视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gameId", value = "游戏ID", required = true, paramType = "query"),
    })
    public R getVideosByGameId(@RequestParam String gameId) {
        List<LinkedHashMap> videoList = videoService.getVideosByGameId(gameId);
        videoList = videoList.subList(0, Math.min(videoList.size(), 20));
        return R.ok().put("videoList", videoList);
    }

    @GetMapping("/getVideosBySongId")
    @ApiOperation("根据曲目id获取视频信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "songId", value = "曲目ID", required = true, paramType = "query"),
    })
    public R getVideosBySongId(@RequestParam String songId) {
        List<LinkedHashMap> videoList = videoService.getVideosBySongId(songId);
        videoList = videoList.subList(0, Math.min(videoList.size(), 20));
        return R.ok().put("videoList", videoList);
    }

    @GetMapping("/getRank")
    @ApiOperation("获取视频排名")
    public R getRank() throws IOException {
        File file = new File("D:\\result.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write("date,,name,value" + "\r\n");
        LocalDate date = LocalDate.of(2019, 1, 1);
        while (date.getYear() <= 2019) {
            System.out.println(date.toString());
            List<HashMap> result = videoDao.getRank(date.plusDays(1).toString());
            for (HashMap hashMap : result) {
                bWriter.write(date.toString() + "," + hashMap.get("uid") + ","
                        + hashMap.get("id") + "," + hashMap.get("play") + "\r\n");
                bWriter.flush();
            }
            date = date.plusDays(1);
        }
        bWriter.close();
        return R.ok();
    }

    @GetMapping("/getRankWithoutDssq")
    @ApiOperation("获取非dssq视频排名")
    public R getRankWithoutDssq() throws IOException {
        File file = new File("D:\\result_avg.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write("date,,name,value" + "\r\n");
        LocalDate date = LocalDate.of(2019, 1, 1);
        while (date.getYear() <= 2019) {
            System.out.println(date.toString());
            List<HashMap> result = videoDao.getRankWithoutDssq(date.plusDays(1).toString());
            for (HashMap hashMap : result) {
                bWriter.write(date.toString() + "," + hashMap.get("uid") + ","
                        + hashMap.get("id") + "," + hashMap.get("play_avg") + "\r\n");
                bWriter.flush();
            }
            date = date.plusDays(1);
        }
        bWriter.close();
        return R.ok();
    }
}
