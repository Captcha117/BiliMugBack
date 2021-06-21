package io.oken1.modules.game.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@Data
public class GameModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 游戏ID
     */
    private String gameId;
    /**
     * 常用名称
     */
    private String commonName;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 图标版本
     */
    private Integer iconVersion;
    /**
     * 其他名称
     */
    private String otherName;
    /**
     * 开发商
     */
    private String developer;
    /**
     * 父游戏ID
     */
    private String parentId;
    /**
     * 更新时间
     */
    private Date updateTime;
}
