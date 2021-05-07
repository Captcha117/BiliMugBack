package io.oken1.modules.video.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import io.oken1.common.utils.DateUtils;
import io.oken1.modules.video.dao.VideoDao;
import io.oken1.modules.video.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.oken1.common.utils.R;


@Api(value = "视频", tags = {"视频"})
@RestController
@RequestMapping("/video")
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
        List<LinkedHashMap> videoList = videoDao.getVideosByGameId(gameId,
                DateUtils.format(DateUtils.addDateMonths(new Date(), -6)),
                DateUtils.format(new Date()));
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

    @GetMapping("/getUpRank")
    @ApiOperation("获取视频排名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = true, paramType = "query")
    })
    public R getUpRank(String startDate, String endDate) throws IOException {
        File file = new File("D:\\result.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write("date,,name,value" + "\r\n");
        Date queryDate = DateUtils.stringToDate(startDate);
        Date end = DateUtils.stringToDate(endDate);
        while (queryDate.getTime() <= end.getTime()) {
            System.out.println(queryDate.toString());
            Boolean needProportion = DateUtils.addDateDays(queryDate, 5).getTime() < end.getTime();
            List<HashMap> result = videoDao.getUpRank(startDate, DateUtils.format(queryDate), needProportion);
            for (HashMap hashMap : result) {
                bWriter.write(DateUtils.format(queryDate) + "," + hashMap.get("uid") + ","
                        + hashMap.get("id") + "," + hashMap.get("play") + "\r\n");
                bWriter.flush();
            }
            queryDate = DateUtils.addDateDays(queryDate, 1);
        }
        bWriter.close();
        return R.ok();
    }

    @GetMapping("/getGameRank")
    @ApiOperation("获取视频排名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "开始日期", required = true, paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", required = true, paramType = "query")
    })
    public R getGameRank(String startDate, String endDate) throws IOException {
        File file = new File("D:\\GameRank2020.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write("date,,name,value" + "\r\n");
        Date queryDate = DateUtils.stringToDate(startDate);
        Date end = DateUtils.stringToDate(endDate);
        while (queryDate.getTime() <= end.getTime()) {
            System.out.println(queryDate.toString());
            List<HashMap> result = videoDao.getGameRank(startDate, DateUtils.format(queryDate));
            for (HashMap hashMap : result) {
                bWriter.write(DateUtils.format(queryDate) + "," + hashMap.get("game_id") + ","
                        + hashMap.get("game") + "," + hashMap.get("play") + "\r\n");
                bWriter.flush();
            }
            queryDate = DateUtils.addDateDays(queryDate, 1);
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
