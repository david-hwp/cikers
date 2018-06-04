package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 医生表
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
@TableName("t_doctor")
@Data
public class DoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 医生姓名
	 */
private String name;
	/**
	 * 头像
	 */
private String avatar;
	/**
	 * 年龄
	 */
private Integer age;
	/**
	 * 性别：1-男，0-女
	 */
private Integer gender;
	/**
	 * 从业时间
	 */
private Integer workingYears;
	/**
	 * 手机
	 */
private String mobile;
	/**
	 * 擅长手术类型id（多个以逗号隔开）
	 */
private String surgeryType;
	/**
	 * 医师认证
	 */
private String doctorTitle;
	/**
	 * 创建时间
	 */
private Date createTime;
	/**
	 * 修改时间
	 */
private Date updateTime;

}
