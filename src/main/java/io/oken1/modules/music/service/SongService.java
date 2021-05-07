package io.oken1.modules.music.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.music.entity.SongEntity;

import java.util.LinkedHashMap;

public interface SongService extends IService<SongEntity> {
    LinkedHashMap getSongInfo(String songId);
}

