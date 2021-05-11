package io.oken1.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.oken1.common.utils.ShiroUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自动填充处理类
 *
 * @author badao
 * @version 1.0
 * @see
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 在执行mybatisPlus的insert()时，为我们自动给某些字段填充值，这样的话，我们就不需要手动给insert()里的实体类赋值了
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //其中方法参数中第一个是前面自动填充所对应的字段，第二个是要自动填充的值。第三个是指定实体类的对象
        this.setFieldValByName("createUser", ShiroUtils.getUserId(), metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateUser", ShiroUtils.getUserId(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    /**
     * 在执行mybatisPlus的update()时，为我们自动给某些字段填充值，这样的话，我们就不需要手动给update()里的实体类赋值了
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateUser", ShiroUtils.getUserId(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}