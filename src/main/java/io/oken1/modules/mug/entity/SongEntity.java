package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_song")
public class SongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String songId;

    private String gameId;

    private String singleId;

    private String songTitleEn;
    private String songTitleJp;
    private String songTitleCn;
    private String songAlias;
    private String songArtist;
    private String songLength;
    private String songStyle;
    private String gameVersion;
    private Date releaseDate;
    private String SongBpm;
    private String SongInx;
}
