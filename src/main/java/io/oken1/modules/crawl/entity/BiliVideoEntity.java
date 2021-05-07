package io.oken1.modules.crawl.entity;

public class BiliVideoEntity {

    public VideoDetail data;

    public VideoDetail getData() {
        return data;
    }

    public void setData(VideoDetail data) {
        this.data = data;
    }

    public class VideoDetail {
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
         * 播放
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
         * 点赞
         */
        public Integer like;

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
    }
}
