package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.UploaderEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface UploaderDao extends BaseMapper<UploaderEntity> {
    LinkedHashMap getUploaderRankByUid(Long uid);

    List<LinkedHashMap> getUploaderVideoByUid(Long uid);

    List<LinkedHashMap> getUploaderGameByUid(Long uid);

    //config
    List<LinkedHashMap> getUploaderConfigList();

    List<LinkedHashMap> searchUploader(String search);
}
