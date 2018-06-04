package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 机构表
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
@TableName("t_organization")
@Data
public class OrganizationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 机构名称
	 */
private String name;
	/**
	 * 机构头像
	 */
private String avatar;
	/**
	 * 座机
	 */
private String telephone;
	/**
	 * 手机
	 */
private String mobile;
	/**
	 * 详细地址
	 */
private String address;
	/**
	 * 创建时间
	 */
private Date createTime;
	/**
	 * 修改时间
	 */
private Date updateTime;

}
