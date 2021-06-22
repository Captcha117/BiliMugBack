package io.oken1.modules.music.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_single_relation")
public class SingleRelationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private int pkId;
    /**
     * 单曲ID
     */
    private String singleId;
    /**
     * 衍生单曲ID
     */
    private String relateId;

}
