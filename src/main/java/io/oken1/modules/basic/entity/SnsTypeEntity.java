package io.oken1.modules.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_sns_type")
public class SnsTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * SNS类型
     */
    @TableId(type = IdType.INPUT)
    private String snsTypeId;
    /**
     * SNS中文
     */
    private String snsCn;
    /**
     * SNS英文
     */
    private String snsEn;
    /**
     * SNS日文
     */
    private String snsJp;
    /**
     * 默认地址
     */
    private String defaultUrl;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private String inx;
}
