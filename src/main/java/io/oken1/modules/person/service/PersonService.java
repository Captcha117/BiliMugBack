package io.oken1.modules.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.person.entity.PersonEntity;

public interface PersonService extends IService<PersonEntity> {
    void processSongArtist(String gameId);
}
