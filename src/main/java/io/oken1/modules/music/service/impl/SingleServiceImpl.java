package io.oken1.modules.music.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.music.dao.SingleDao;
import io.oken1.modules.music.entity.SingleEntity;
import io.oken1.modules.music.service.SingleService;
import org.springframework.stereotype.Service;


@Service("SingleService")
public class SingleServiceImpl extends ServiceImpl<SingleDao, SingleEntity> implements SingleService {
}