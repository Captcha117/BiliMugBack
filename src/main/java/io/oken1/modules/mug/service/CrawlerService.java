package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.VideoEntity;

import java.util.LinkedHashMap;
import java.util.List;

public interface CrawlerService {
    Object crawlVideosByPage(int pageCount);

    Object crawlVideosByPage(int startPage, int endPage);
}

