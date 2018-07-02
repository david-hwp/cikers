package com.cikers.wechat.mall.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cikers.wechat.mall.modules.app.entity.EquipmentEntity;
import com.cikers.wechat.mall.modules.app.form.ProductForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
@Mapper
public interface EquipmentDao extends BaseMapper<EquipmentEntity> {

    int truncate();

    List<EquipmentEntity> queryList(ProductForm productForm);
}
