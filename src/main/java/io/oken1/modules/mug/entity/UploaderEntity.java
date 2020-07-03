package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_uploader")
public class UploaderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * UID
     */
    @TableId(type = IdType.INPUT)
    private Long uid;
    /**
     * ID
     */
    private String id;
    /**
     * 头像
     */
    private String face;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public UploaderEntity(Long uid, String id, String face) {
        this.uid = uid;
        this.id = id;
        this.face = face;
    }
}
