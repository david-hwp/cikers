package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 手术信息
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@TableName("t_surgery")
@Data
public class SurgeryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 手术项目名称
	 */
private String name;
	/**
	 * 手术类型ID
	 */
private Integer type;
	/**
	 * 手术价格
	 */
private BigDecimal amount;
	/**
	 * 客户性别：1-男，0-女
	 */
private Integer clientGender;
	/**
	 * 客户身高：单位cm
	 */
private String clientHeight;
	/**
	 * 客户身高：单位kg
	 */
private String clientWeight;
	/**
	 * 术前照片（多张以逗号隔开)
	 */
private String preoperativePhotos;
	/**
	 * 手术时间
	 */
private Date surgeryTime;
	/**
	 * 创建时间
	 */
private Date createTime;
	/**
	 * 修改时间
	 */
private Date updateTime;

}
