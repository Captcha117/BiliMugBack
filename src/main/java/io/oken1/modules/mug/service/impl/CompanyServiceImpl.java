package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.mug.dao.CompanyDao;
import io.oken1.modules.mug.entity.CompanyEntity;
import io.oken1.modules.mug.service.CompanyService;
import org.springframework.stereotype.Service;

@Service("CompanyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity>  implements CompanyService {
}
