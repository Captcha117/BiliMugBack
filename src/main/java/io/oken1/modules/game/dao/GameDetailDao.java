package io.oken1.modules.game.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface GameDetailDao {
    /**
     * 游戏曲包列表
     */
    List<LinkedHashMap> getPackageListByGameId(String gameId);

    /**
     * 游戏版本更新列表
     */
    List<LinkedHashMap> getVersionListByGameId(String gameId);

    /**
     * 游戏SNS列表
     */
    List<LinkedHashMap> getSnsListByGameId(String gameId);

    /**
     * 游戏难度列表
     */
    List<LinkedHashMap> getDifficultyListByGameId(String gameId);
}
