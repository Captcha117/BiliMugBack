package io.oken1.modules.mug.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface BasicDao {
    List<LinkedHashMap> getAllSnsList();

    List<LinkedHashMap> getAllCompanyList();
}
