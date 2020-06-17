package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_song")
public class SongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private String songId;
}
