package io.oken1.modules.mug.entity;

import java.util.List;

public class BiliVideoEntity {
    public videoDetail getData() {
        return data;
    }

    public void setData(videoDetail data) {
        this.data = data;
    }

    public String ttl;

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public videoDetail data;

    public class videoDetail {
        public List<archives> archives;

        public List<archives> getArchives() {
            return archives;
        }

        public void setArchives(List<archives> archives) {
            this.archives = archives;
        }

        public class archives {
            /**
             * 视频AV号
             */
            public String aid;
            /**
             * 视频BV号
             */
            public String bvid;
            /**
             * 1=原创 2=搬运
             */
            public String copyright;
            /**
             * 发布unix时间
             */
            public String pubdate;
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
            public String duration;
            /**
             * 视频分P数
             */
            public String videos;
            /**
             * UP主
             **/
            public Owner owner;
            /**
             * 视频详情
             */
            public Stat stat;

            public String getAid() {
                return aid;
            }

            public void setAid(String aid) {
                this.aid = aid;
            }

            public String getBvid() {
                return bvid;
            }

            public void setBvid(String bvid) {
                this.bvid = bvid;
            }

            public String getCopyright() {
                return copyright;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public String getPubdate() {
                return pubdate;
            }

            public void setPubdate(String pubdate) {
                this.pubdate = pubdate;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getTitle() {
                return title.replace("\n", "").replace("	", "");
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public void setVideos(String videos) {
                this.videos = videos;
            }

            public String getVideos() {
                return this.videos;
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

            public String archivesToString() {
                /**
                 *AV+标题+时间戳+Excel时间+原创/搬运+分P数+时长+UP主string+视频详情string
                 */
                return this.getAid() + "	" + this.getTitle() + "	" + this.getPubdate() + "	"
                        + ((Double.parseDouble(this.getPubdate()) + 28800) / 86400 + 25569) + "	" + this.getCopyright()
                        + "	" + this.getVideos() + "	" + this.getDuration() + "	" + this.owner.ownerToString()
                        + this.stat.statToString();
            }

            /**
             * UP主
             */
            public class Owner {
                /**
                 * UP主UID
                 */
                public String mid;
                /**
                 * UP主ID
                 */
                public String name;
                /**
                 * UP主头像
                 */
                public String face;

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
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
                public String aid;
                /**
                 * 播放量
                 */
                public String view;
                /**
                 * 弹幕
                 */
                public String danmaku;
                /**
                 * 评论
                 */
                public String reply;
                /**
                 * 收藏
                 */
                public String favorite;
                /**
                 * 硬币
                 */
                public String coin;
                /**
                 * 分享
                 */
                public String share;
                /**
                 * 赞
                 */
                public String like;
                /**
                 * 踩
                 */
                public String dislike;

                public String getAid() {
                    return aid;
                }

                public void setAid(String aid) {
                    this.aid = aid;
                }

                public String getView() {
                    return view;
                }

                public void setView(String view) {
                    this.view = view;
                }

                public String getDanmaku() {
                    return danmaku;
                }

                public void setDanmaku(String danmaku) {
                    this.danmaku = danmaku;
                }

                public String getReply() {
                    return reply;
                }

                public void setReply(String reply) {
                    this.reply = reply;
                }

                public String getFavorite() {
                    return favorite;
                }

                public void setFavorite(String favorite) {
                    this.favorite = favorite;
                }

                public String getCoin() {
                    return coin;
                }

                public void setCoin(String coin) {
                    this.coin = coin;
                }

                public String getShare() {
                    return share;
                }

                public void setShare(String share) {
                    this.share = share;
                }

                public String getLike() {
                    return like;
                }

                public void setLike(String like) {
                    this.like = like;
                }

                public String getDislike() {
                    return dislike;
                }

                public void setDislike(String dislike) {
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
