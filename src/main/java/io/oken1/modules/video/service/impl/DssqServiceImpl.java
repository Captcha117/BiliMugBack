package io.oken1.modules.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.video.dao.DssqDao;
import io.oken1.modules.video.entity.DssqEntity;
import io.oken1.modules.video.service.DssqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DssqService")
public class DssqServiceImpl extends ServiceImpl<DssqDao, DssqEntity> implements DssqService {

    @Autowired
    DssqDao dssqDao;

    @Override
    public Object showTitleDssq(String startDate, String endDate) {
        Object result = dssqDao.showTitleDssq(startDate, endDate);
        return result;
    }

    @Override
    public Object insertTitleDssq(String startDate, String endDate) {
        try {
            dssqDao.insertTitleDssq(startDate, endDate);
        } catch (Exception e) {
            return e;
        }
        return "success";
    }
}
