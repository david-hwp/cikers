package com.cikers.wechat.mall.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.app.entity.ProductEntity;

import java.util.List;
import java.util.Map;

/**
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
public interface ProductService extends IService<ProductEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int truncate();

    List<ProductEntity> getProductByEqptId(Long eqptId);
}

