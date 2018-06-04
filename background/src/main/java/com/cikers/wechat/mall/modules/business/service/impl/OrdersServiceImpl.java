package com.cikers.wechat.mall.modules.business.service.impl;

import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;
import com.cikers.wechat.mall.modules.business.dao.OrdersDao;
import com.cikers.wechat.mall.modules.business.entity.OrdersEntity;
import com.cikers.wechat.mall.modules.business.service.OrdersService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, OrdersEntity> implements OrdersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrdersEntity> page = this.selectPage(
                new Query<OrdersEntity>(params).getPage(),
                new EntityWrapper<OrdersEntity>()
        );

        return new PageUtils(page);
    }

}
