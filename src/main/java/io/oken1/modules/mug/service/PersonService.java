package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.PersonEntity;

public interface PersonService extends IService<PersonEntity> {
    void processSongArtist(String gameId);
}
