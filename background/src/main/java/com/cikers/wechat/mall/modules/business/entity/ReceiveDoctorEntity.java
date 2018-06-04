package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单关联接单医生信息
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@TableName("t_receive_doctor")
@Data
public class ReceiveDoctorEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 订单id
	 */
private Integer orderId;
	/**
	 * 接单医生id
	 */
private Integer doctorId;
	/**
	 * 接单状态：1-被选中，0-未被选中
	 */
private Integer status;
	/**
	 * 创建时间
	 */
private Date createTime;
	/**
	 * 修改时间
	 */
private Date updateTime;

}
