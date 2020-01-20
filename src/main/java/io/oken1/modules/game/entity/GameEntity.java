package io.oken1.modules.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author oken1
 * @email /
 * @date 2020-01-16 14:46:31
 */
@Data
@TableName("game")
public class GameEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 游戏ID
	 */
	@TableId
	private String gameId;
	/**
	 * 英文全称
	 */
	private String nameEn;
	/**
	 * 英文简称
	 */
	private String nameEnAbbr;
	/**
	 * 中文全称
	 */
	private String nameCn;
	/**
	 * 日文全称
	 */
	private String nameJp;
	/**
	 * 日文简称
	 */
	private String nameJpAbbr;
	/**
	 * 默认语言 CJE
	 */
	private String defaultLang;
	/**
	 * 图标文件名
	 */
	private String icon;
	/**
	 * 开发商
	 */
	private String developer;
	/**
	 * 发行商
	 */
	private String publisher;
	/**
	 * 发行时间
	 */
	private Date publishTime;
	/**
	 * 标签
	 */
	private String tags;
	/**
	 * 父游戏ID
	 */
	private String parentId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新人
	 */
	private String updateUser;

}
