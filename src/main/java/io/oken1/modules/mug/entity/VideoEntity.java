package io.oken1.modules.mug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(type = IdType.INPUT)
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDssq() {
        return dssq;
    }

    public void setDssq(String dssq) {
        this.dssq = dssq;
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

    public VideoEntity(Integer aid, String bid, String title, Integer pubTime, Integer copyright, Integer ps,
                       Integer duration, Integer uid, Integer play, Integer danmu, Integer comment, Integer favorite,
                       Integer coin, Integer share, Integer iine) {
        this.aid = aid;
        this.bid = bid;
        this.title = title;
        this.pubTime = pubTime;
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
    }
}
