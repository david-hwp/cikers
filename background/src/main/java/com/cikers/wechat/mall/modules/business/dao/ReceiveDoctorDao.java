package com.cikers.wechat.mall.modules.business.dao;

import com.cikers.wechat.mall.modules.business.entity.ReceiveDoctorEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cikers.wechat.mall.modules.business.entity.ReceiveDoctorEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单关联接单医生信息
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
@Mapper
public interface ReceiveDoctorDao extends BaseMapper<ReceiveDoctorEntity> {
	
}
