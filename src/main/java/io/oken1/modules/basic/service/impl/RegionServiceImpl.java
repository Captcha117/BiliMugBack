package io.oken1.modules.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.basic.dao.RegionDao;
import io.oken1.modules.basic.entity.RegionEntity;
import io.oken1.modules.basic.service.RegionService;
import org.springframework.stereotype.Service;

@Service("NationService")
public class RegionServiceImpl extends ServiceImpl<RegionDao, RegionEntity> implements RegionService {
}
