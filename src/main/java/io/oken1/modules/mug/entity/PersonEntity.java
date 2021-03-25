package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.oken1.common.utils.MyUtils;
import lombok.Data;


@Data
@TableName("mug_person")
public class PersonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 人物ID
     */
    @TableId
    private String personId;
    /**
     * 人物名称
     */
    private String personName;
    /**
     * 人物别名
     */
    private String personAlias;
    /**
     *  人物国家/地区
     */
    private String personNation;
    /**
     * 人物描述
     */
    private String personDescription;
}
