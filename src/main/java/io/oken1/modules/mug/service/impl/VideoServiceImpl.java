package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.VideoDao;
import io.oken1.modules.mug.entity.VideoEntity;
import io.oken1.modules.mug.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;


@Service("VideoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, VideoEntity> implements VideoService {

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<LinkedHashMap> getVideosBySongId(String songId) {
        return videoDao.getVideosBySongId(songId);
    }

    @Override
    public List<LinkedHashMap> getVideosByDates(Date startDate, Date endDate) {
        return videoDao.getVideosByDates(startDate, endDate);
    }

}