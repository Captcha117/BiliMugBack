package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.PackageSongDao;
import io.oken1.modules.game.entity.PackageSongEntity;
import io.oken1.modules.game.service.PackageSongService;
import org.springframework.stereotype.Service;

@Service("PackageSongService")
public class PackageSongServiceImpl extends ServiceImpl<PackageSongDao, PackageSongEntity> implements PackageSongService {
}
