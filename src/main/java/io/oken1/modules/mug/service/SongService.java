package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.SongEntity;

import java.util.LinkedHashMap;
import java.util.List;

public interface SongService extends IService<SongEntity> {
    LinkedHashMap getSongInfo(String songId);
}

