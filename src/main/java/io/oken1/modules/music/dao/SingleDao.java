package io.oken1.modules.music.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.music.entity.SingleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SingleDao extends BaseMapper<SingleEntity> {
    List<SingleEntity> getSingleList();

    List<SingleEntity> searchSingle(String search);
}
