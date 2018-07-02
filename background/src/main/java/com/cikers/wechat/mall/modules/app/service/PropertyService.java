package com.cikers.wechat.mall.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性表
 *
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
public interface PropertyService extends IService<PropertyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int truncate();

    List<PropertyEntity> queryTypes();
}

