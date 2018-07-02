package com.cikers.wechat.mall.modules.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;
import com.cikers.wechat.mall.modules.app.dao.PropertyRelationDao;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import com.cikers.wechat.mall.modules.app.entity.PropertyRelationEntity;
import com.cikers.wechat.mall.modules.app.service.PropertyRelationService;
import com.cikers.wechat.mall.modules.app.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("equipmentPropertyRelationService")
public class PropertyRelationServiceImpl extends ServiceImpl<PropertyRelationDao, PropertyRelationEntity> implements PropertyRelationService {

    @Autowired
    private PropertyService propertyService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PropertyRelationEntity> page = this.selectPage(
                new Query<PropertyRelationEntity>(params).getPage(),
                new EntityWrapper<PropertyRelationEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public int truncate() {
        return baseMapper.truncate();
    }

    public Map<String, PropertyEntity> selectByEqptId(Long eqptId) {
        List<PropertyRelationEntity> propertyRelationEntities = baseMapper.selectByEqptId(eqptId);
        Map<String, PropertyEntity> propertyEntityMap = new HashMap<>();
        for (PropertyRelationEntity relationEntity : propertyRelationEntities) {
            PropertyEntity propertyEntity = propertyService.selectById(relationEntity.getPropertyId());
            if (propertyEntity != null) {
                propertyEntityMap.put(relationEntity.getPropertyName(), propertyEntity);
            }
        }
        return propertyEntityMap;
    }

    @Override
    public Map<String, PropertyEntity> selectByProductId(Long productId) {
        List<PropertyRelationEntity> propertyRelationEntities = baseMapper.selectByProductId(productId);
        Map<String, PropertyEntity> propertyEntityMap = new HashMap<>();
        for (PropertyRelationEntity relationEntity : propertyRelationEntities) {
            PropertyEntity propertyEntity = propertyService.selectById(relationEntity.getPropertyId());
            if (propertyEntity != null) {
                propertyEntityMap.put(relationEntity.getPropertyName(), propertyEntity);
            }
        }
        return propertyEntityMap;
    }
}
