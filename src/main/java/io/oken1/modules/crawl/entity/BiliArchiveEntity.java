package io.oken1.modules.crawl.entity;

import java.util.List;

/**
 * B站视频页实体类
 */
public class BiliArchiveEntity {
    public VideoDetail getData() {
        return data;
    }

    public void setData(VideoDetail data) {
        this.data = data;
    }

    public String ttl;

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public VideoDetail data;

    public class VideoDetail {
        public List<Archives> archives;

        public List<Archives> getArchives() {
            return archives;
        }

        public void setArchives(List<Archives> archives) {
            this.archives = archives;
        }

        public class Archives {
            /**
             * 视频AV号
             */
            public Long aid;
            /**
             * 视频BV号
             */
            public String bvid;
            /**
             * 1=原创 2=搬运
             */
            public Integer copyright;
            /**
             * 发布unix时间
             */
            public Long pubdate;
            /**
             * ?
             */
            public String ctime;
            /**
             * 标题
             */
            public String title;
            /**
             * 时长
             */
            public Integer duration;
            /**
             * 视频分P数
             */
            public Integer videos;
            /**
             * 封面链接
             */
            public String pic;
            /**
             * UP主
             **/
            public Owner owner;
            /**
             * 视频详情
             */
            public Stat stat;

            public Long getAid() {
                return aid;
            }

            public void setAid(Long aid) {
                this.aid = aid;
            }

            public String getBvid() {
                return bvid;
            }

            public void setBvid(String bvid) {
                this.bvid = bvid;
            }

            public Integer getCopyright() {
                return copyright;
            }

            public void setCopyright(Integer copyright) {
                this.copyright = copyright;
            }

            public Long getPubdate() {
                return pubdate;
            }

            public void setPubdate(Long pubdate) {
                this.pubdate = pubdate;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getTitle() {
                return title.replace("\n", "").replace("	", "").replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
            }

            public void setTitle(String title) {
                this.title = title.replace("\n", "").replace("	", "").replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "");
            }

            public Integer getDuration() {
                return duration;
            }

            public void setDuration(Integer duration) {
                this.duration = duration;
            }

            public void setVideos(Integer videos) {
                this.videos = videos;
            }

            public Integer getVideos() {
                return this.videos;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getPic() {
                return this.pic;
            }

            public Owner getOwner() {
                return owner;
            }

            public void setOwner(Owner owner) {
                this.owner = owner;
            }

            public Stat getStat() {
                return stat;
            }

            public void setStat(Stat stat) {
                this.stat = stat;
            }

            /**
             * UP主
             */
            public class Owner {
                /**
                 * UP主UID
                 */
                public Long mid;
                /**
                 * UP主ID
                 */
                public String name;
                /**
                 * UP主头像
                 */
                public String face;

                public Long getMid() {
                    return mid;
                }

                public void setMid(Long mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFace() {
                    return face;
                }

                public void setFace(String face) {
                    this.face = face;
                }

                /**
                 * UID+ID
                 */
                public String ownerToString() {
                    return this.getMid() + "	" + this.getName() + "	";
                }
            }

            public class Stat {
                /**
                 * 视频AID
                 */
                public Integer aid;
                /**
                 * 播放量
                 */
                public Integer view;
                /**
                 * 弹幕
                 */
                public Integer danmaku;
                /**
                 * 评论
                 */
                public Integer reply;
                /**
                 * 收藏
                 */
                public Integer favorite;
                /**
                 * 硬币
                 */
                public Integer coin;
                /**
                 * 分享
                 */
                public Integer share;
                /**
                 * 赞
                 */
                public Integer like;
                /**
                 * 踩
                 */
                public Integer dislike;

                public Integer getAid() {
                    return aid;
                }

                public void setAid(Integer aid) {
                    this.aid = aid;
                }

                public Integer getView() {
                    return view;
                }

                public void setView(Integer view) {
                    this.view = view;
                }

                public Integer getDanmaku() {
                    return danmaku;
                }

                public void setDanmaku(Integer danmaku) {
                    this.danmaku = danmaku;
                }

                public Integer getReply() {
                    return reply;
                }

                public void setReply(Integer reply) {
                    this.reply = reply;
                }

                public Integer getFavorite() {
                    return favorite;
                }

                public void setFavorite(Integer favorite) {
                    this.favorite = favorite;
                }

                public Integer getCoin() {
                    return coin;
                }

                public void setCoin(Integer coin) {
                    this.coin = coin;
                }

                public Integer getShare() {
                    return share;
                }

                public void setShare(Integer share) {
                    this.share = share;
                }

                public Integer getLike() {
                    return like;
                }

                public void setLike(Integer like) {
                    this.like = like;
                }

                public Integer getDislike() {
                    return dislike;
                }

                public void setDislike(Integer dislike) {
                    this.dislike = dislike;
                }

                /**
                 * 播放+弹幕+评论+收藏+硬币+分享+好评+差评
                 */
                public String statToString() {
                    return this.getView() + "	" + this.getDanmaku() + "	" + this.getReply() + "	"
                            + this.getFavorite() + "	" + this.getCoin() + "	" + this.getShare() + "	"
                            + this.getLike() + "	" + this.getDislike();
                }
            }
        }
    }
}
