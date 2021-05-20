package io.oken1.modules.person.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName("mug_person")
public class PersonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 人物ID
     */
    @TableId(type = IdType.INPUT)
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
     * 人物国家/地区
     */
    private String personRegion;
    /**
     * 人物描述
     */
    private String personDescription;
}
