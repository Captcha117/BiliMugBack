package io.oken1.modules.music.model;

import io.oken1.modules.game.entity.ChartEntity;
import io.oken1.modules.music.entity.SongEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SongModel extends SongEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    List<ChartEntity> charts;
}
