package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.PersonEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao extends BaseMapper<PersonEntity> {
}
