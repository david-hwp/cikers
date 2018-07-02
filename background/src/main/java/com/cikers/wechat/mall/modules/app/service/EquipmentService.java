package com.cikers.wechat.mall.modules.app.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.app.entity.EquipmentEntity;
import com.cikers.wechat.mall.modules.app.form.ProductForm;

import java.util.List;
import java.util.Map;

/**
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
public interface EquipmentService extends IService<EquipmentEntity> {
    PageUtils queryPage(Map<String, Object> params);

    int truncate();

    List<EquipmentEntity> queryList(ProductForm productForm);
}
