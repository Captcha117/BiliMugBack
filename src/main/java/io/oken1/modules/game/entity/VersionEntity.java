package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mug_version")
public class VersionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @TableId
    private Integer versionId;
    /**
     * 游戏ID
     */
    private String gameId;
    /**
     * 版本号
     */
    private String versionNo;
    /**
     * 版本信息
     */
    private String versionInfo;
    /**
     * 更新时间
     */
    private Date versionDate;
}
