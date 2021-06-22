package io.oken1.modules.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.music.entity.SingleRelationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface SingleRelationDao extends BaseMapper<SingleRelationEntity> {
    List<LinkedHashMap> getSingleRelationListBySingleId(String singleId);
}
