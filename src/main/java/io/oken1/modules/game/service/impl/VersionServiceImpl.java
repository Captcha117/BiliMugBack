package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.VersionDao;
import io.oken1.modules.game.entity.VersionEntity;
import io.oken1.modules.game.service.VersionService;
import org.springframework.stereotype.Service;

@Service("VersionService")
public class VersionServiceImpl extends ServiceImpl<VersionDao, VersionEntity> implements VersionService {
}
