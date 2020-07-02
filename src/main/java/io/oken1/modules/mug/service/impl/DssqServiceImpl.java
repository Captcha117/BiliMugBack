package io.oken1.modules.mug.service.impl;

import io.oken1.modules.mug.service.DssqService;
import io.oken1.modules.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("DssqService")
public class DssqServiceImpl implements DssqService {

    @Autowired
    SysConfigService sysConfigService;

    @Override
    public void updateDssq(String startDate) {
        String[] dssqWordList = sysConfigService.getValue("dssqWord").split(",");

    }
}
