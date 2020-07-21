package io.oken1.modules.mug.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.modules.mug.entity.ContentEntity;
import io.oken1.modules.mug.entity.DssqEntity;

public interface DssqService {
    Object showTitleDssq(String startDate, String endDate);

    Object insertTitleDssq(String startDate, String endDate);
}

