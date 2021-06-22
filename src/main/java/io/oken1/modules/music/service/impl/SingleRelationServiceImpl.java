package io.oken1.modules.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.music.dao.SingleRelationDao;
import io.oken1.modules.music.entity.SingleRelationEntity;
import io.oken1.modules.music.service.SingleRelationService;
import org.springframework.stereotype.Service;


@Service("SingleRelationService")
public class SingleRelationServiceImpl extends ServiceImpl<SingleRelationDao, SingleRelationEntity> implements SingleRelationService {
}