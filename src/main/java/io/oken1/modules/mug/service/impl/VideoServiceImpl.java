package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.VideoDao;
import io.oken1.modules.mug.entity.VideoEntity;
import io.oken1.modules.mug.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;


@Service("videoService")
public class VideoServiceImpl extends ServiceImpl<VideoDao, VideoEntity> implements VideoService {

    @Autowired
    VideoDao videoDao;

    @Override
    public List<LinkedHashMap> getVideosByGameId(String gameId) {
        return videoDao.getVideosByGameId(gameId);
    }

    @Override
    public List<LinkedHashMap> getVideosBySongId(String songId) {
        return videoDao.getVideosBySongId(songId);
    }
}