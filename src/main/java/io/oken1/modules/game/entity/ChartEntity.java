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
     * 难度ID
     */
    private Integer difficultyId;
    /**
     * 等级
     */
    private String chartLevel;
    /**
     * 官方定数
     */
    private Float chartBase;
    /**
     * 谱师
     */
    private String chartDesigner;
    /**
     * 是否可用
     */
    private Integer chartUsable;
}
