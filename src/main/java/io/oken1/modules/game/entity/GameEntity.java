package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("mug_game")
public class GameEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    @TableId(type = IdType.INPUT)
    private String gameId;
    /**
     * 常用名称
     */
    private String gameName;
    /**
     * 图标版本
     */
    @TableField(updateStrategy = FieldStrategy.NOT_NULL)
    private Integer iconVersion;
    /**
     * 其他名称
     */
    private String otherName;
    /**
     * 开发商
     */
    private String developer;
    /**
     * 发行商
     */
    private String publisher;
    /**
     * 发行日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishDate;
    /**
     * 游戏标签
     */
    private String gameTag;
    /**
     * 视频标签
     */
    private String videoTag;
    /**
     * 父游戏ID
     */
    private String parentId;
    /**
     * 类音游
     */
    private String similar;
    /**
     * 过滤排序
     */
    private Integer filterIndex;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;
}
