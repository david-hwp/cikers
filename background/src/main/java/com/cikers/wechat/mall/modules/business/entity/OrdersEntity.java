package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 订单信息
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@TableName("t_orders")
@Data
public class OrdersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 手术id
	 */
private Integer surgeryId;
	/**
	 * 手术城市
	 */
private String surgeryCity;
	/**
	 * 机构id
	 */
private Integer organizationId;
	/**
	 * 订单状态：1-已发布，2-已接单，3-已完成，4-已取消
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
