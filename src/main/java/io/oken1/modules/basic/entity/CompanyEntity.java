package io.oken1.modules.basic.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_company")
public class CompanyEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 公司ID
     */
    @TableId(type = IdType.INPUT)
    private String companyId;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司别名
     */
    private String companyAlias;
    /**
     * 公司地区
     */
    private String companyRegion;
    /**
     * 公司地址
     */
    private String companyAddress;
}
