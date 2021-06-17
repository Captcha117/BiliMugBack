package io.oken1.modules.person.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.person.entity.PersonEntity;

public interface PersonService extends IService<PersonEntity> {
    /**
     * 曲目艺术家标签化
     *
     * @param gameId 游戏ID
     */
    void processSongArtist(String gameId);
}
