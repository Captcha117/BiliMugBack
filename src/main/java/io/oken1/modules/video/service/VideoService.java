package io.oken1.modules.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.video.entity.VideoEntity;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public interface VideoService extends IService<VideoEntity> {

    List<LinkedHashMap> getVideosBySongId(String songId);

    List<LinkedHashMap> getVideosByDates(Date startDate, Date endDate);
}

