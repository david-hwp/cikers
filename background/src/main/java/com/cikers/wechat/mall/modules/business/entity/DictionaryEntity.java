package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典信息
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@TableName("t_dictionary")
@Data
public class DictionaryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 常量类型：1-手术类型
	 */
private Integer type;
	/**
	 * 常量名称
	 */
private String name;
	/**
	 * 描述
	 */
private String description;
	/**
	 * 创建时间
	 */
private Date createTime;
	/**
	 * 修改时间
	 */
private Date updateTime;

}
