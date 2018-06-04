package com.cikers.wechat.mall.modules.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.modules.business.entity.DoctorEntity;
import com.cikers.wechat.mall.common.utils.PageUtils;

import java.util.Map;

/**
 * 医生表
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
public interface DoctorService extends IService<DoctorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

