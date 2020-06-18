package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.UploaderDao;
import io.oken1.modules.mug.entity.UploaderEntity;
import io.oken1.modules.mug.service.UploaderService;
import org.springframework.stereotype.Service;

@Service("UploaderService")
public class UploaderServiceImpl extends ServiceImpl<UploaderDao, UploaderEntity>  implements UploaderService {
}
