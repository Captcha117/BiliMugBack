package io.oken1.modules.video.controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.oken1.modules.video.service.VideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.oken1.modules.game.entity.GameEntity;
import io.oken1.modules.game.service.GameService;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.R;


/**
 * @author oken1
 * @email /
 * @date 2020-01-16 14:46:31
 */
@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getVideosByGameId")
    public R getVideosByGameId(@RequestParam String gameId) {
        List<LinkedHashMap> videoList = videoService.getVideosByGameId(gameId).subList(0, 20);

        return R.ok().put("videoList", videoList);
    }

}
