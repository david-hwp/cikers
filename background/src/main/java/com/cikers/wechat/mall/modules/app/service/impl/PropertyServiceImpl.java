package com.cikers.wechat.mall.modules.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;
import com.cikers.wechat.mall.modules.app.dao.PropertyDao;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import com.cikers.wechat.mall.modules.app.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("propertyService")
public class PropertyServiceImpl extends ServiceImpl<PropertyDao, PropertyEntity> implements PropertyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PropertyEntity> page = this.selectPage(
                new Query<PropertyEntity>(params).getPage(),
                new EntityWrapper<PropertyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public boolean insert(PropertyEntity propertyEntity) {
        PropertyEntity result = selectById(propertyEntity.getId());
        if (result == null) {
            baseMapper.insert(propertyEntity);
        }
        return true;
    }

    @Override
    public int truncate() {
        return baseMapper.truncate();
    }

    @Override
    public List<PropertyEntity> queryTypes() {
        return baseMapper.queryTypes();
    }

}
