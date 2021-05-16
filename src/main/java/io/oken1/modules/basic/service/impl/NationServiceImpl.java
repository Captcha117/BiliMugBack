package io.oken1.modules.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.basic.dao.NationDao;
import io.oken1.modules.basic.entity.NationEntity;
import io.oken1.modules.basic.service.NationService;
import org.springframework.stereotype.Service;

@Service("NationService")
public class NationServiceImpl extends ServiceImpl<NationDao, NationEntity> implements NationService {
}
