package io.oken1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 业务配置
 *
 */
@Component
public class BizConfig {
    @Value("${biz.biliApiUrl}")
    public String biliApiUrl;
}
