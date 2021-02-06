package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.oken1.common.utils.MyUtils;
import lombok.Data;


@Data
@TableName("mug_game")
public class GameEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    @TableId
    private Integer gameId;
    /**
     * 常用名称
     */
    private String commonName;
    /**
     * 全称
     */
    private String fullName;
    /**
     *  图标版本
     */
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
     * 发行时间
     */
    private String publishTime;
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
    private Float filterIndex;
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
