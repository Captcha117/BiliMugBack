package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_difficulty")
public class DifficultyEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 难度ID
     */
    @TableId
    private Integer difficultyId;
    /**
     * 游戏ID
     */
    private String gameId;
    /**
     * 难度名称
     */
    private String difficultyName;
    /**
     * 难度简称
     */
    private String difficultyAbbr;
    /**
     * 颜色
     */
    private String color;
    /**
     * 排序
     */
    private Integer inx;
}
