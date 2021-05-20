package io.oken1.modules.person.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.modules.person.dao.GroupDao;
import io.oken1.modules.person.entity.GroupEntity;
import io.oken1.modules.person.service.GroupService;
import org.springframework.stereotype.Service;

@Service("GroupService")
public class GroupServiceImpl extends ServiceImpl<GroupDao, GroupEntity> implements GroupService {
}
