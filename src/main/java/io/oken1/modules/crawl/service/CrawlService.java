package io.oken1.modules.crawl.service;

public interface CrawlService {
    Object crawlVideosByPage(int pageCount);

    Object crawlVideosByPage(int startPage, int endPage);

    Object crawlUploaderById(String id);

    Object crawlVideoById(String id);
}

