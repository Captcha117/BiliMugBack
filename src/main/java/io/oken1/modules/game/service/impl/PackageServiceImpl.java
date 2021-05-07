package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.ChartDao;
import io.oken1.modules.game.dao.PackageDao;
import io.oken1.modules.game.entity.ChartEntity;
import io.oken1.modules.game.entity.PackageEntity;
import io.oken1.modules.game.service.ChartService;
import io.oken1.modules.game.service.PackageService;
import org.springframework.stereotype.Service;

@Service("PackageService")
public class PackageServiceImpl extends ServiceImpl<PackageDao, PackageEntity> implements PackageService {
}
