package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.GroupMemberEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface GroupMemberDao extends BaseMapper<GroupMemberEntity> {
    List<LinkedHashMap> getGroupMemberConfigList();

    List<LinkedHashMap> getGroupMemberConfigListByGroupId(String groupId);
}
