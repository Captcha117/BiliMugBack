package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_chart")
public class ChartEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 谱面ID
     */
    @TableId
    private Integer chartId;
    /**
     * 曲目ID
     */
    private String songId;
    /**
     * 模式ID
     */
    private Integer modeId;
    /**
     * 难度ID
     */
    private Integer difficultyId;
    /**
     * 等级
     */
    private String chartLevel;
    /**
     * 是否可用
     */
    private Integer chartUsable;
}
