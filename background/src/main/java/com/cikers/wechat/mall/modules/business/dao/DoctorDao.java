package com.cikers.wechat.mall.modules.business.dao;

import com.cikers.wechat.mall.modules.business.entity.DoctorEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cikers.wechat.mall.modules.business.entity.DoctorEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 医生表
 * 
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
@Mapper
public interface DoctorDao extends BaseMapper<DoctorEntity> {
	
}
