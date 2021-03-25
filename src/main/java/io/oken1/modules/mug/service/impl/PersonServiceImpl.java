package io.oken1.modules.mug.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bestvike.linq.Linq;
import io.oken1.common.utils.MyUtils;
import io.oken1.modules.mug.dao.PersonDao;
import io.oken1.modules.mug.dao.SongDao;
import io.oken1.modules.mug.entity.PersonEntity;
import io.oken1.modules.mug.entity.SongEntity;
import io.oken1.modules.mug.service.PersonService;
import io.oken1.modules.mug.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("PersonService")
public class PersonServiceImpl extends ServiceImpl<PersonDao, PersonEntity> implements PersonService {
    @Autowired
    SongService songService;
    @Autowired
    SongDao songDao;

    @Override
    public void processSongArtist(String gameId) {
        //曲目列表
        List<SongEntity> songList = songDao.getBriefSongListByGameId(gameId);

        List<PersonEntity> artistList = this.list();
        //遍历曲目
        for (SongEntity song : songList) {
            String artistName = song.getSongArtist();
            String newArtistName = artistName;
            if(song.getSongId().equals("d35b793d"))
            {
                int a = 2;
            }
            //遍历人物
            for (PersonEntity artist : artistList) {
                String[] artistNames = (artist.getPersonName() + "," + MyUtils.nvl(artist.getPersonAlias(), "")).split(",");
                //遍历人名
                for (String name : artistNames) {
                    if (Pattern.matches("(?i)\\b" + name + "\\b", artistName) && !Pattern.matches("(?i)\\|" + name + "}", artistName)) {
                        // 创建 Pattern 对象
                        Pattern r = Pattern.compile("(?i)\\b" + name + "\\b");
                        // 现在创建 matcher 对象
                        Matcher m = r.matcher(artistName);
                        if (m.find()) {
                            newArtistName = artistName.replace(m.group(0), "{" + artist.getPersonId() + "|" + m.group(0) + "}");
                        }
                    }
                }
            }
            if (!artistName.equals(newArtistName)) {
                song.setSongArtist(newArtistName);
                songService.saveOrUpdate(song);
            }
        }
    }
}
