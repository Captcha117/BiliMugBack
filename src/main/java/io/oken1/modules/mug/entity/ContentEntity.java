package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_video_content")
public class ContentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long pkId;
    /**
     * AV号
     */
    private Long aid;
    /**
     * 类型
     */
    private String type;
    /**
     * 内容ID
     */
    private Integer contentId;
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
