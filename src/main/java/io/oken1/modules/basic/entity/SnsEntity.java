package io.oken1.modules.basic.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("mug_sns")
public class SnsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * SNS类型
     */
    private String pkId;
    /**
     * 项目对应ID
     */
    private String itemId;
    /**
     * 项目类型(G:游戏，C:公司，P:人)
     */
    private String itemType;
    /**
     * SNS类型
     */
    private String snsType;
    /**
     * SNS地址
     */
    private String snsUrl;
}
