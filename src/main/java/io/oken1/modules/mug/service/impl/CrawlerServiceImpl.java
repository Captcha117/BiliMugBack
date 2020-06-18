package io.oken1.modules.mug.service.impl;


import com.google.gson.Gson;
import io.oken1.config.BizConfig;
import io.oken1.modules.mug.entity.BiliVideoEntity;
import io.oken1.modules.mug.entity.UploaderEntity;
import io.oken1.modules.mug.entity.VideoEntity;
import io.oken1.modules.mug.service.CrawlerService;
import io.oken1.modules.mug.service.UploaderService;
import io.oken1.modules.mug.service.VideoService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("crawlerService")
public class CrawlerServiceImpl implements CrawlerService {
    @Autowired
    private BizConfig bizConfig;

    @Autowired
    private VideoService videoService;

    @Autowired
    private UploaderService uploaderService;

    private static Gson gson = new Gson();

    @Override
    public Object crawlVideosByPage(int pageCount) {
        return crawlVideos(1, pageCount);
    }

    @Override
    public Object crawlVideosByPage(int startPage, int endPage) {
        return crawlVideos(startPage, endPage);
    }

    /**
     * 视频列表爬虫
     *
     * @param startPage 开始页数
     * @param endPage   结束页数
     * @return
     */
    public Object crawlVideos(int startPage, int endPage) {
        CloseableHttpClient client = HttpClients.createDefault();
        int page = endPage;
        try {
            for (; page >= startPage; page--) {
                String url = bizConfig.biliApiUrl + "/x/web-interface/newlist?rid=136&pn=" + page + "&ps=20";
                HttpGet httpGet = new HttpGet(url);
                CloseableHttpResponse response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity);
                BiliVideoEntity biliVideo = gson.fromJson(str, BiliVideoEntity.class);
                saveData(biliVideo);
                if (page % 10 == 0) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(600);
                }
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return "error occurred at page " + page;
        }
        return "success! Total pages: " + (endPage - startPage + 1);
    }

    /**
     * 保存视频和UP主信息
     *
     * @param biliVideo
     */
    public void saveData(BiliVideoEntity biliVideo) {
        List<BiliVideoEntity.videoDetail.archives> videoList = biliVideo.getData().getArchives();
        List<VideoEntity> saveVideoList = new ArrayList<>();
        List<UploaderEntity> saveUpList = new ArrayList<>();
        for (BiliVideoEntity.videoDetail.archives l : videoList
        ) {
            BiliVideoEntity.videoDetail.archives.Stat stat = l.getStat();
            BiliVideoEntity.videoDetail.archives.Owner owner = l.getOwner();

            VideoEntity videoEntity = new VideoEntity(l.getAid(), l.getBvid(), l.getTitle(), l.getPubdate(),
                    l.getCopyright(), l.getVideos(), l.getDuration(), l.getOwner().getMid(), stat.getView(),
                    stat.getDanmaku(), stat.getReply(), stat.getFavorite(), stat.getCoin(), stat.getShare(),
                    stat.getLike(), l.getPic());
            videoEntity.setUpdateUser(1L);
            videoEntity.setUpdateTime(new Date());

            UploaderEntity uploaderEntity = new UploaderEntity
                    (owner.getMid(), owner.getName(), owner.getFace(), new Date());

            saveVideoList.add(videoEntity);
            saveUpList.add(uploaderEntity);
        }
        videoService.saveOrUpdateBatch(saveVideoList);
        uploaderService.saveOrUpdateBatch(saveUpList);
    }
}
