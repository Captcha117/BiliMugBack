package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
@TableName("mug_video")
public class VideoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * AV号
     */
    @TableId
    private Integer aid;
    /**
     * BV号
     */
    private String bid;
    /**
     * 标题
     */
    private String title;
    /**
     * 发布时间戳
     */
    private Integer pubTime;
    /**
     * 自制1，搬运2
     */
    private Integer copyright;
    /**
     * 分P数
     */
    private Integer ps;
    /**
     * 时长(s)
     */
    private Integer duration;
    /**
     * UP主ID
     */
    private Integer uid;
    /**
     * 播放
     */
    private Integer play;
    /**
     * 弹幕
     */
    private Integer danmu;
    /**
     * 评论
     */
    private Integer comment;
    /**
     * 收藏
     */
    private Integer favorite;
    /**
     * 硬币
     */
    private Integer coin;
    /**
     * 分享
     */
    private Integer share;
    /**
     * 点赞
     */
    private Integer iine;
    /**
     * 标签
     */
    private String tag;
    /**
     * dssq?
     */
    private String dssq;
    /**
     * 更新人
     */
    private Long updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;

}
