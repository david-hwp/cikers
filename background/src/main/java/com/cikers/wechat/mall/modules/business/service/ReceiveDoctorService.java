package com.cikers.wechat.mall.modules.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.business.entity.ReceiveDoctorEntity;

import java.util.Map;

/**
 * 订单关联接单医生信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
public interface ReceiveDoctorService extends IService<ReceiveDoctorEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

