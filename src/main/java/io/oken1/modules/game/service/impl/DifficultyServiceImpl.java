package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.DifficultyDao;
import io.oken1.modules.game.entity.DifficultyEntity;
import io.oken1.modules.game.service.DifficultyService;
import org.springframework.stereotype.Service;

@Service("DifficultyService")
public class DifficultyServiceImpl extends ServiceImpl<DifficultyDao, DifficultyEntity> implements DifficultyService {
}
