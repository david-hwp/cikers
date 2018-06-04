package com.cikers.wechat.mall.modules.business.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 审核信息
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@TableName("t_check")
@Data
public class CheckEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
@TableId
private Integer id;
	/**
	 * 审核类型：1-机构，2-医生
	 */
private Integer checkType;
	/**
	 * 审核人id-后台用户
	 */
private Integer checkId;
	/**
	 * 审核人姓名
	 */
private String checkName;
	/**
	 * 审核时间
	 */
private Date checkTime;
	/**
	 * 图片1（机构-营业执照；医生-职业资格证）
	 */
private String picture1;
	/**
	 * 图片2（机构-卫生许可证；医生-职称证书）
	 */
private String picture2;
	/**
	 * 审核状态：0-待审核，1-已通过
	 */
private Integer state;
	/**
	 * 创建时间
	 */
private Date createTime;
	/**
	 * 修改时间
	 */
private Date updateTime;

}
