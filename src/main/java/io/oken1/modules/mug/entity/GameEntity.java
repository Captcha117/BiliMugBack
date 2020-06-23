package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
@TableName("mug_game")
public class GameEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    @TableId
    private String gameId;
    /**
     * 常用名称
     */
    private String commonName;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 其它名称
     */
    private String otherName;
    /**
     * 图标文件名
     */
    private String icon;
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
    private Date publishTime;
    /**
     * 标签
     */
    private String tags;
    /**
     * 父游戏ID
     */
    private String parentId;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

}
