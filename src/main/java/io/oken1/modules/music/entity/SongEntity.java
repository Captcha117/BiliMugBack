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
@TableName("mug_song")
public class SongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 曲目ID
     */
    @TableId(type = IdType.INPUT)
    private String songId;
    /**
     * 所属游戏ID
     */
    private String gameId;
    /**
     * 所属单曲ID
     */
    private String singleId;
    /**
     * 英文曲名
     */
    private String songTitleEn;
    /**
     * 日文曲名
     */
    private String songTitleJp;
    /**
     * 中文曲名
     */
    private String songTitleCn;
    /**
     * 游戏内标注的艺术家
     */
    private String songArtist;
    /**
     * 时长
     */
    private String songLength;
    /**
     * 收录版本
     */
    private String gameVersion;
    /**
     * 收录日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Date releaseDate;
    /**
     * BPM
     */
    private String SongBpm;
    /**
     * 描述
     */
    private String SongDescription;
    /**
     * 排序
     */
    private String SongInx;
}
