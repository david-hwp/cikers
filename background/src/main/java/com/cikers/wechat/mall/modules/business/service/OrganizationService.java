package com.cikers.wechat.mall.modules.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.business.entity.OrganizationEntity;

import java.util.Map;

/**
 * 机构表
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:04:44
 */
public interface OrganizationService extends IService<OrganizationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

