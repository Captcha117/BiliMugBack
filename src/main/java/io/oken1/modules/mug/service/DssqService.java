package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.entity.DssqEntity;

public interface DssqService {
    Object showDssq(String startDate, String endDate);

    Object insertDssq(String startDate, String endDate);
}

