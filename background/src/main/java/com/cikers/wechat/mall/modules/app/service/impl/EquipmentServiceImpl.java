package com.cikers.wechat.mall.modules.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;
import com.cikers.wechat.mall.modules.app.dao.EquipmentDao;
import com.cikers.wechat.mall.modules.app.entity.EquipmentEntity;
import com.cikers.wechat.mall.modules.app.entity.ProductEntity;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import com.cikers.wechat.mall.modules.app.form.ProductForm;
import com.cikers.wechat.mall.modules.app.service.EquipmentService;
import com.cikers.wechat.mall.modules.app.service.ProductService;
import com.cikers.wechat.mall.modules.app.service.PropertyRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("equipmentService")
public class EquipmentServiceImpl extends ServiceImpl<EquipmentDao, EquipmentEntity> implements EquipmentService {
    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyRelationService propertyRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EquipmentEntity> page = this.selectPage(
                new Query<EquipmentEntity>(params).getPage(),
                new EntityWrapper<EquipmentEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int truncate() {
        return baseMapper.truncate();
    }

    @Override
    public List<EquipmentEntity> queryList(ProductForm productForm) {
        productForm.setOffset((productForm.getPageIndex() - 1) * productForm.getPageSize());

        List<EquipmentEntity> equipmentEntities = baseMapper.queryList(productForm);
        if (equipmentEntities != null) {
            for (EquipmentEntity equipmentEntity : equipmentEntities) {
                List<ProductEntity> productEntities = productService.getProductByEqptId(equipmentEntity.getId());
                if (productEntities != null) {
                    equipmentEntity.setProudcts(productEntities);
                }
                Map<String, PropertyEntity> propertyEntityMap = propertyRelationService.selectByEqptId(equipmentEntity.getId());
                if (propertyEntityMap != null) {
                    equipmentEntity.setProps(propertyEntityMap);
                }
            }
            return equipmentEntities;
        }
        return null;
    }
}
