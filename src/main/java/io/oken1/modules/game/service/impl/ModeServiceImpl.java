package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.ModeDao;
import io.oken1.modules.game.entity.ModeEntity;
import io.oken1.modules.game.service.ModeService;
import org.springframework.stereotype.Service;

@Service("ModeService")
public class ModeServiceImpl extends ServiceImpl<ModeDao, ModeEntity> implements ModeService {
}
