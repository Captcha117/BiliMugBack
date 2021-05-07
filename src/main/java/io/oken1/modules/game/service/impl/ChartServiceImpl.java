package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.ChartDao;
import io.oken1.modules.game.dao.DifficultyDao;
import io.oken1.modules.game.entity.ChartEntity;
import io.oken1.modules.game.entity.DifficultyEntity;
import io.oken1.modules.game.service.ChartService;
import io.oken1.modules.game.service.DifficultyService;
import org.springframework.stereotype.Service;

@Service("ChartService")
public class ChartServiceImpl extends ServiceImpl<ChartDao, ChartEntity> implements ChartService {
}
