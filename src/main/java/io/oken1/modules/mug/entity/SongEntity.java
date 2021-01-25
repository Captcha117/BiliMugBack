package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_song")
public class SongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer songId;

    private Integer gameId;

    private Integer singleId;

    private String title;
}
