package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_mode")
public class ModeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 模式ID
     */
    @TableId
    private Integer modeId;
    /**
     * 游戏ID
     */
    private String gameId;
    /**
     * 模式名称
     */
    private String modeName;
    /**
     * 排序
     */
    private Integer inx;
}
