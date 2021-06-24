package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.UploaderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface UploaderDao extends BaseMapper<UploaderEntity> {
    /**
     * 根据uid获取UP主有效视频播放排行
     *
     * @param uid UP主uid
     * @return UP主有效视频播放排行
     */
    LinkedHashMap getUploaderRankByUid(Long uid);

    /**
     * 根据uid获取UP主各游戏有效播放排行
     *
     * @param uid UP主uid
     * @return UP主各游戏有效播放排行
     */
    List<LinkedHashMap> getUploaderGameRankListByUid(Long uid);

    /**
     * 根据uid获取UP主视频列表
     *
     * @param uid UP主uid
     * @return UP主视频列表（按视频播放倒序）
     */
    List<LinkedHashMap> getUploaderVideoByUid(Long uid);

    /**
     * 根据uid获取UP主投稿的游戏列表
     *
     * @param uid UP主uid
     * @return UP主投稿的游戏列表（按投稿数量倒序）
     */
    List<LinkedHashMap> getUploaderGameByUid(Long uid);

    //config
    List<LinkedHashMap> getUploaderConfigList();

    List<LinkedHashMap> searchUploader(String search);
}
