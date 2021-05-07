package io.oken1.modules.game.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.game.dao.KeywordDao;
import io.oken1.modules.game.entity.KeywordEntity;
import io.oken1.modules.game.service.KeywordService;
import org.springframework.stereotype.Service;

@Service("KeywordService")
public class KeywordServiceImpl extends ServiceImpl<KeywordDao, KeywordEntity> implements KeywordService {
}
