package io.oken1.modules.mug.entity;

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
        public Integer aid;
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
        public Integer pubdate;
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

        public Integer getAid() {
            return aid;
        }

        public void setAid(Integer aid) {
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

        public Integer getPubdate() {
            return pubdate;
        }

        public void setPubdate(Integer pubdate) {
            this.pubdate = pubdate;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public Integer getVideos() {
            return videos;
        }

        public void setVideos(Integer videos) {
            this.videos = videos;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}
