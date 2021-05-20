package io.oken1.modules.person.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("mug_group")
public class GroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 团队ID
     */
    @TableId(type = IdType.INPUT)
    private String groupId;
    /**
     * 团队名
     */
    private String groupName;
    /**
     * 团队别名
     */
    private String groupAlias;
    /**
     * 团队国家/地区
     */
    private String groupRegion;
    /**
     * 建立日期
     */
    private Date createDate;
    /**
     * 解散日期
     */
    private Date dissolutionDate;
    /**
     * 团队描述
     */
    private String groupDescription;
}
