package com.cikers.wechat.mall.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import com.cikers.wechat.mall.modules.app.entity.PropertyRelationEntity;

import java.util.Map;

/**
 * 装备属性关系表
 *
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
public interface PropertyRelationService extends IService<PropertyRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int truncate();

    Map<String, PropertyEntity> selectByEqptId(Long eqptId);

    Map<String, PropertyEntity> selectByProductId(Long productId);
}

