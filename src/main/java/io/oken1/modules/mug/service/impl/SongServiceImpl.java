package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.SongDao;
import io.oken1.modules.mug.entity.SongEntity;
import io.oken1.modules.mug.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;


@Service("SongService")
public class SongServiceImpl extends ServiceImpl<SongDao, SongEntity> implements SongService {

    @Autowired
    SongDao songDao;

    @Override
    public LinkedHashMap getSongInfo(String songId) {
        return songDao.getSongInfo(songId);
    }
}