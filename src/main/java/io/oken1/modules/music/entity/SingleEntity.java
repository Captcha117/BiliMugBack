package io.oken1.modules.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_single")
public class SingleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 曲目ID
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
     * 曲目别名
     */
    //private String songAlias;
    /**
     * 艺术家
     */
    private String singleArtist;
    /**
     * 收录日期
     */
    private Date releaseDate;
    /**
     * BPM
     */
    private String singleBpm;
}
