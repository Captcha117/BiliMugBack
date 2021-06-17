package io.oken1.modules.person.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.person.entity.PersonEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface PersonDao extends BaseMapper<PersonEntity> {
    /**
     * 根据人物ID获取人物供曲游戏
     *
     * @param personId 人物ID
     * @return 人物供曲游戏列表
     */
    List<LinkedHashMap> getPersonGameByPersonId(String personId);

    /**
     * 根据人物ID获取人物供曲和进行谱面制作的曲目
     *
     * @param personId 人物ID
     * @return 供曲和进行谱面制作的曲目列表
     */
    List<LinkedHashMap> getPersonSongByPersonId(String personId);

    /**
     * 根据人物ID获取人物单曲
     *
     * @param personId 人物ID
     * @return 单曲列表
     */
    List<LinkedHashMap> getPersonSingleByPersonId(String personId);

    //config
    List<LinkedHashMap> getPersonConfigList();

    LinkedHashMap getPersonInfoByPersonId(String personId);

    List<LinkedHashMap> searchPerson(String search);
}
