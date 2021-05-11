package io.oken1.modules.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.basic.dao.SnsTypeDao;
import io.oken1.modules.basic.entity.SnsTypeEntity;
import io.oken1.modules.basic.service.SnsTypeService;
import org.springframework.stereotype.Service;

@Service("SnsTypeService")
public class SnsTypeServiceImpl extends ServiceImpl<SnsTypeDao, SnsTypeEntity> implements SnsTypeService {
}
