package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_package_song")
public class PackageSongEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Integer pkId;
    /**
     * 曲包ID
     */
    private String packageId;
    /**
     * 曲目ID
     */
    private String songId;
    /**
     * 发布时间
     */
    private Date addDate;
}
