package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_package")
public class PackageEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 曲包ID
     */
    @TableId(type = IdType.INPUT)
    private String packageId;
    /**
     * 游戏ID
     */
    private String gameId;
    /**
     * 曲包名称
     */
    private String packageName;
    /**
     * 曲包价格
     */
    private String packagePrice;
    /**
     * 发布日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private Date releaseDate;
    /**
     * 描述
     */
    private String description;
    /**
     * 备注
     */
    private String remarks;
}
