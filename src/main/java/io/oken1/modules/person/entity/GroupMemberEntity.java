package io.oken1.modules.person.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("mug_group_member")
public class GroupMemberEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer pkId;
    /**
     * 团队ID
     */
    private String groupId;
    /**
     * 人物ID
     */
    private String person_id;
    /**
     * 入队时间
     */
    private Date joinDate;
    /**
     * 离队时间
     */
    private Date leaveDate;
    /**
     * 备注
     */
    private String remark;
}
