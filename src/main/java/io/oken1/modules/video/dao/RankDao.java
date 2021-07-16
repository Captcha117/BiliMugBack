package io.oken1.modules.video.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface RankDao {
    /**
     * 获取游戏排行
     */
    List<LinkedHashMap> gameRank(String startDate, String endDate);

    /**
     * 获取UP主排行
     */
    List<LinkedHashMap> upRank(String startDate, String endDate,
                               String referStartDate, String referEndDate, Integer minPlay);

    /**
     * 更新UP主年度总播放排行
     */
    void insertUploaderYearRank();

    /**
     * 更新UP主年度游戏排行
     */
    void insertUploaderGameYearRank();

    /**
     * 获取最近更新排行的时间
     */
    LinkedHashMap getRecentYearRankUpdateTime();

    /**
     * 根据游戏ID获取UP主排行
     */
    List<LinkedHashMap> getUpRankByGameId(String[] gameIds);
}
