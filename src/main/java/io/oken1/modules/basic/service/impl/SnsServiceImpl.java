package io.oken1.modules.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.basic.dao.SnsDao;
import io.oken1.modules.basic.entity.SnsEntity;
import io.oken1.modules.basic.service.SnsService;
import org.springframework.stereotype.Service;

@Service("SnsService")
public class SnsServiceImpl extends ServiceImpl<SnsDao, SnsEntity> implements SnsService {
}
