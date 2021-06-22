package io.oken1.modules.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_single")
public class SingleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 单曲ID
     */
    @TableId(type = IdType.INPUT)
    private String singleId;
    /**
     * 英文曲名
     */
    private String singleTitleEn;
    /**
     * 日文曲名
     */
    private String singleTitleJp;
    /**
     * 中文曲名
     */
    private String singleTitleCn;
    /**
     * 单曲别名
     */
    private String singleAlias;
    /**
     * 艺术家
     */
    private String singleArtist;
    /**
     * 时长
     */
    private String singleLength;
    /**
     * 发布日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Date releaseDate;
    /**
     * BPM
     */
    private String singleBpm;
    /**
     * 演职人员
     */
    private String singleCast;
    /**
     * 歌词
     */
    private String singleLyric;
}
