package io.oken1.modules.mug.service.impl;


import com.google.gson.Gson;
import io.oken1.common.utils.ShiroUtils;
import io.oken1.config.BizConfig;
import io.oken1.modules.mug.entity.BiliUploaderEntity;
import io.oken1.modules.mug.entity.BiliArchiveEntity;
import io.oken1.modules.mug.entity.UploaderEntity;
import io.oken1.modules.mug.entity.VideoEntity;
import io.oken1.modules.mug.service.CrawlerService;
import io.oken1.modules.mug.service.UploaderService;
import io.oken1.modules.mug.service.VideoService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
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
     * @return 爬虫结果
     */
    public Object crawlVideos(int startPage, int endPage) {
        CloseableHttpClient client = HttpClients.createDefault();
        int page = endPage;
        try {
            for (; page >= startPage; page--) {
                String url = bizConfig.biliApiUrl + "/x/web-interface/newlist?rid=136&pn=" + page + "&ps=20";
                HttpGet httpGet = new HttpGet(url);
                HttpResponse response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity);
                BiliArchiveEntity biliArchive = gson.fromJson(str, BiliArchiveEntity.class);
                saveData(biliArchive);
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
     * 根据AV号获取视频信息
     *
     * @param id AID
     * @return
     */
    public Object crawlVideoById(int id) {
        String url = bizConfig.biliApiUrl + "/x/web-interface/archive/stat?aid=" + id;
        return crawlVideo(url);
    }

    /**
     * 根据BV号获取视频信息
     *
     * @param id BVID
     * @return
     */
    public Object crawlVideoById(String id) {
        String url = bizConfig.biliApiUrl + "/x/web-interface/archive/stat?bvid=" + id;
        return crawlVideo(url);
    }

    public Object crawlVideo(String url) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity);
            VideoEntity videoEntity = gson.fromJson(str, VideoEntity.class);
            saveData(videoEntity);
        } catch (Exception e) {
            return "error";
        }
        return "success!";
    }

    /**
     * 用户信息爬虫
     *
     * @param id 用户ID
     * @return 爬虫结果
     */
    @Override
    public Object crawlUploaderById(String id) {
        try {
            String url = bizConfig.biliApiUrl + "/x/web-interface/card?mid=" + id;
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            String str = EntityUtils.toString(response.getEntity());
            BiliUploaderEntity biliUploaderEntity = gson.fromJson(str, BiliUploaderEntity.class);
            saveData(biliUploaderEntity);
        } catch (Exception e) {
            return "error";
        }
        return "success!";
    }

    /**
     * 保存视频和UP主信息
     *
     * @param biliArchive
     */
    public void saveData(BiliArchiveEntity biliArchive) {
        List<BiliArchiveEntity.VideoDetail.Archives> videoList = biliArchive.getData().getArchives();
        List<VideoEntity> saveVideoList = new ArrayList<>();
        List<UploaderEntity> saveUpList = new ArrayList<>();
        for (BiliArchiveEntity.VideoDetail.Archives l : videoList
        ) {
            BiliArchiveEntity.VideoDetail.Archives.Stat stat = l.getStat();
            BiliArchiveEntity.VideoDetail.Archives.Owner owner = l.getOwner();

            VideoEntity videoEntity = new VideoEntity(l.getAid(), l.getBvid(), l.getTitle(), l.getPubdate(),
                    l.getCopyright(), l.getVideos(), l.getDuration(), l.getOwner().getMid(), stat.getView(),
                    stat.getDanmaku(), stat.getReply(), stat.getFavorite(), stat.getCoin(), stat.getShare(),
                    stat.getLike(), l.getPic());
            videoEntity.setUpdateUser(ShiroUtils.getUserId());
            videoEntity.setUpdateTime(new Date());

            UploaderEntity uploaderEntity = new UploaderEntity
                    (owner.getMid(), owner.getName(), owner.getFace(), new Date());

            saveVideoList.add(videoEntity);
            saveUpList.add(uploaderEntity);
        }
        videoService.saveOrUpdateBatch(saveVideoList);
        uploaderService.saveOrUpdateBatch(saveUpList);
    }

    public void saveData(VideoEntity videoEntity) {

    }

    public void saveData(BiliUploaderEntity biliUploaderEntity) {
        BiliUploaderEntity.UserData.Card card = biliUploaderEntity.getData().getCard();
        UploaderEntity uploaderEntity = new UploaderEntity(card.getMid(), card.getName(), card.getFace(), new Date());
        uploaderService.saveOrUpdate(uploaderEntity);
    }
}
