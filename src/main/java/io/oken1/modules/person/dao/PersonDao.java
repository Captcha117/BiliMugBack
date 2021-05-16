package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.PersonEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface PersonDao extends BaseMapper<PersonEntity> {
    List<LinkedHashMap> getPersonConfigList();

    List<LinkedHashMap> searchPerson(String search);
}
