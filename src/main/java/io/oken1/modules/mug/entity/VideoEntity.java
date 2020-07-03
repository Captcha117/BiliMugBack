package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.oken1.common.utils.DateUtils;
import lombok.Data;

@Data
@TableName("mug_video")
public class VideoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * AV号
     */
    @TableId(type = IdType.INPUT)
    private Long aid;
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
    private Date pubTime;
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
    private Long uid;
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
     * 封面链接
     */
    private String folder;
    /**
     * 标签
     */
    private String tag;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public VideoEntity() {
    }

    public VideoEntity(Long aid, String bvid, Integer copyright, Integer view, Integer danmaku, Integer reply,
                       Integer favorite, Integer coin, Integer share, Integer like) {
        this.aid = aid;
        this.bid = bvid;
        this.copyright = copyright;
        this.play = view;
        this.danmu = danmaku;
        this.comment = reply;
        this.favorite = favorite;
        this.coin = coin;
        this.share = share;
        this.iine = like;
    }

    public VideoEntity(Long aid, String bid, String title, Long pubUnixTime, Integer copyright, Integer ps,
                       Integer duration, Long uid, Integer play, Integer danmu, Integer comment, Integer favorite,
                       Integer coin, Integer share, Integer iine, String folder) {
        this.aid = aid;
        this.bid = bid;
        this.title = title;
        this.pubTime = DateUtils.unixToDate(pubUnixTime);
        this.copyright = copyright;
        this.ps = ps;
        this.duration = duration;
        this.uid = uid;
        this.play = play;
        this.danmu = danmu;
        this.comment = comment;
        this.favorite = favorite;
        this.coin = coin;
        this.share = share;
        this.iine = iine;
        this.folder = folder;
    }
}
