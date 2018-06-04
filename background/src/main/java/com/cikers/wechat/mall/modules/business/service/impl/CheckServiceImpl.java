package com.cikers.wechat.mall.modules.business.service.impl;

import com.cikers.wechat.mall.modules.business.dao.CheckDao;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;

import com.cikers.wechat.mall.modules.business.entity.CheckEntity;
import com.cikers.wechat.mall.modules.business.service.CheckService;


@Service("checkService")
public class CheckServiceImpl extends ServiceImpl<CheckDao, CheckEntity> implements CheckService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheckEntity> page = this.selectPage(
                new Query<CheckEntity>(params).getPage(),
                new EntityWrapper<CheckEntity>()
        );

        return new PageUtils(page);
    }

}
