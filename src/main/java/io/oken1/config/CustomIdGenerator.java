package io.oken1.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import io.oken1.common.utils.MyUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        return null;
    }

    @Override
    public String nextUUID(Object entity){
        return MyUtils.myUUID();
    }
}