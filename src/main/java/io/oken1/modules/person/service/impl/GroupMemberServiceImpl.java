package io.oken1.modules.person.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.person.dao.GroupMemberDao;
import io.oken1.modules.person.entity.GroupMemberEntity;
import io.oken1.modules.person.service.GroupMemberService;
import org.springframework.stereotype.Service;

@Service("GroupMemberService")
public class GroupMemberServiceImpl extends ServiceImpl<GroupMemberDao, GroupMemberEntity> implements GroupMemberService {
}
