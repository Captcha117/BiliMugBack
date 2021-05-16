package io.oken1.modules.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_nation")
public class NationEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer pkId;
    /**
     * 数字代码
     */
    private String numCode;
    /**
     * 二字码
     */
    private String nationCode;
    /**
     * 三字码
     */
    private String nation3Code;
    /**
     * 中文名称
     */
    private String nationNameCn;
    /**
     * 中文缩写
     */
    private String nationNameAbbr;
    /**
     * 英文名称
     */
    private String nationNameEn;
    /**
     * 大洲
     */
    private String continent;
    /**
     * 世界所处位置
     */
    private String worldRegion;
    /**
     * 地区所属国家ID
     */
    private String nationId;
}
