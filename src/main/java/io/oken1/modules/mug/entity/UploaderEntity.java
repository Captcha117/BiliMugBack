package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Integer uid;
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
    private Date updateTime;

    public UploaderEntity(Integer uid, String id, String face, Date updateTime) {
        this.uid = uid;
        this.id = id;
        this.face = face;
        this.updateTime = updateTime;
    }
}
