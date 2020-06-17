package io.oken1.modules.mug.service.impl;


import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import io.oken1.common.utils.RedisUtils;
import io.oken1.config.BizConfig;
import io.oken1.modules.mug.entity.BiliVideoEntity;
import io.oken1.modules.mug.entity.VideoEntity;
import io.oken1.modules.mug.service.CrawlerService;
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
import java.util.List;

@Service("crawlerService")
public class CrawlerServiceImpl implements CrawlerService {
    @Autowired
    private BizConfig bizConfig;

    @Autowired
    private VideoService videoService;

    private static Gson gson;

    @Override
    public Object crawlVideosByPage(int pageCount) {
        CloseableHttpClient client = HttpClients.createDefault();
        Object responseInfo = null;
        try {
            int page;
            for (page = pageCount; page > 0; page--) {
                String url = bizConfig.biliApiUrl + "/x/web-interface/newlist?rid=136&pn=" + page + "&ps=20";
                HttpGet httpGet = new HttpGet(url);
                CloseableHttpResponse response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String str = EntityUtils.toString(entity);
                BiliVideoEntity biliVideo = gson.fromJson(str, BiliVideoEntity.class);
                saveVideos(biliVideo);
                if (page % 10 == 0) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(600);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return e;
        }
        return responseInfo;
    }

    public void saveVideos(BiliVideoEntity biliVideo) {
        List<BiliVideoEntity.videoDetail.archives> videoList = biliVideo.getData().getArchives();
        List<VideoEntity> saveList = new ArrayList<>();
        videoService.saveOrUpdateBatch(saveList);
    }
}
