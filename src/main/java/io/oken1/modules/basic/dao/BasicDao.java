package io.oken1.modules.basic.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface BasicDao {
    List<LinkedHashMap> getAllSnsList();

    List<LinkedHashMap> getCompanyList();

    List<LinkedHashMap> searchGame(String search);

    List<LinkedHashMap> searchSingle(String search);

    List<LinkedHashMap> searchPerson(String search);

    List<LinkedHashMap> searchUploader(String search);

    List<LinkedHashMap> searchVideo(String search);
}
