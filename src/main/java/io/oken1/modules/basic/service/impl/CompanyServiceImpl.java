package io.oken1.modules.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.basic.dao.CompanyDao;
import io.oken1.modules.basic.entity.CompanyEntity;
import io.oken1.modules.basic.service.CompanyService;
import org.springframework.stereotype.Service;

@Service("CompanyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {
}
