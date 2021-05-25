package io.oken1.modules.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_region")
public class RegionEntity {
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
    private String regionCode;
    /**
     * 三字码
     */
    private String region3Code;
    /**
     * 中文名称
     */
    private String regionNameCn;
    /**
     * 中文缩写
     */
    private String regionNameAbbr;
    /**
     * 英文名称
     */
    private String regionNameEn;
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
