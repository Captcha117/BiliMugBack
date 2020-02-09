package io.oken1.modules.video.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("game")
public class VideoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * AV号
     */
    @TableId
    private String aid;
    /**
     * 标题
     */
    private String title;
}
