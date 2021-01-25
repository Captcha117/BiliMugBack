package io.oken1.modules.mug.service.impl;


import com.google.gson.Gson;
import io.oken1.common.utils.ShiroUtils;
import io.oken1.config.BizConfig;
import io.oken1.modules.mug.entity.*;
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
import java.util.stream.Collectors;

@Service("CrawlerService")
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
     * 爬取第startPage~endPage页的视频信息
     *
     * @param startPage 开始页数
     * @param endPage   结束页数
     * @return 视频信息爬取结果
     */
    public Object crawlVideos(int startPage, int endPage) {
        CloseableHttpClient client = HttpClients.createDefault();
        int page = startPage;
        try {
            for (; page <= endPage; page++) {
                System.out.println("start:" + page);
                String url = bizConfig.biliApiUrl + "/x/web-interface/newlist?rid=136&pn=" + page + "&ps=50";
                HttpGet httpGet = new HttpGet(url);
                HttpResponse response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity);
                BiliArchiveEntity biliArchive = gson.fromJson(str, BiliArchiveEntity.class);
                saveData(biliArchive);
                System.out.println("end:" + page);
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return "error occurred at page " + page;
        }
        return "success! Total pages: " + (endPage - startPage + 1);
    }

    /**
     * 根据AV号或BV号爬取视频信息
     *
     * @param id 视频ID
     * @return 视频信息爬取结果
     */
    @Override
    public Object crawlVideoById(String id) {
        String url = bizConfig.biliApiUrl + "/x/web-interface/archive/stat?";
        url += (id.contains("BV") ? "bvid=" : "aid=") + id;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity);
            BiliVideoEntity biliVideoEntity = gson.fromJson(str, BiliVideoEntity.class);
            saveData(biliVideoEntity);
        } catch (Exception e) {
            return "error";
        }
        return "success!";
    }

    /**
     * 根据ID爬取UP主信息
     *
     * @param id UP主ID
     * @return UP主信息爬取结果
     */
    @Override
    public Object crawlUploaderById(String id) {
        try {
            String url = bizConfig.biliApiUrl + "/x/web-interface/card?mid=" + id;
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity);
            BiliUploaderEntity biliUploaderEntity = gson.fromJson(str, BiliUploaderEntity.class);
            saveData(biliUploaderEntity);
        } catch (Exception e) {
            return "error";
        }
        return "success!";
    }

    /**
     * 根据页码爬取视频信息时，保存视频和UP主信息
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

            UploaderEntity uploaderEntity = new UploaderEntity(owner.getMid(), owner.getName(), owner.getFace());

            saveVideoList.add(videoEntity);
            saveUpList.add(uploaderEntity);
        }
        videoService.saveOrUpdateBatch(saveVideoList);
        uploaderService.saveOrUpdateBatch(saveUpList.stream().distinct().collect(Collectors.toList()));
    }

    /**
     * 根据AV号或BV号爬取视频信息时，保存视频信息
     *
     * @param biliVideoEntity
     */
    public void saveData(BiliVideoEntity biliVideoEntity) {
        BiliVideoEntity.VideoDetail detail = biliVideoEntity.getData();
        VideoEntity videoEntity = new VideoEntity(detail.getAid(), detail.getBvid(), detail.getCopyright(),
                detail.getView(), detail.getDanmaku(), detail.getReply(), detail.getFavorite(), detail.getCoin(),
                detail.getShare(), detail.getLike());
        videoService.saveOrUpdate(videoEntity);
    }

    /**
     * 根据ID爬取UP主信息时，保存UP主信息
     *
     * @param biliUploaderEntity
     */
    public void saveData(BiliUploaderEntity biliUploaderEntity) {
        BiliUploaderEntity.UserData.Card card = biliUploaderEntity.getData().getCard();
        UploaderEntity uploaderEntity = new UploaderEntity(card.getMid(), card.getName(), card.getFace());
        uploaderService.saveOrUpdate(uploaderEntity);
    }
}
