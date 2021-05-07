package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.PackageDao;
import io.oken1.modules.game.dao.PackageSongDao;
import io.oken1.modules.game.entity.PackageEntity;
import io.oken1.modules.game.entity.PackageSongEntity;
import io.oken1.modules.game.service.PackageService;
import io.oken1.modules.game.service.PackageSongService;
import org.springframework.stereotype.Service;

@Service("PackageService")
public class PackageSongServiceImpl extends ServiceImpl<PackageSongDao, PackageSongEntity> implements PackageSongService {
}
