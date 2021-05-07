package io.oken1.modules.person.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.person.dao.UploaderDao;
import io.oken1.modules.person.entity.UploaderEntity;
import io.oken1.modules.person.service.UploaderService;
import org.springframework.stereotype.Service;

@Service("UploaderService")
public class UploaderServiceImpl extends ServiceImpl<UploaderDao, UploaderEntity> implements UploaderService {
}
