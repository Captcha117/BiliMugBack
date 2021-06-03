package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.GroupEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface GroupDao extends BaseMapper<GroupEntity> {
    List<LinkedHashMap> getGroupConfigList();

    LinkedHashMap getGroupInfoByGroupId(String groupId);

    List<LinkedHashMap> searchGroup(String search);
}
