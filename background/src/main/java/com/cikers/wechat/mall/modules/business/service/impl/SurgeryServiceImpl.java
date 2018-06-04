package com.cikers.wechat.mall.modules.business.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;

import com.cikers.wechat.mall.modules.business.dao.SurgeryDao;
import com.cikers.wechat.mall.modules.business.entity.SurgeryEntity;
import com.cikers.wechat.mall.modules.business.service.SurgeryService;


@Service("surgeryService")
public class SurgeryServiceImpl extends ServiceImpl<SurgeryDao, SurgeryEntity> implements SurgeryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SurgeryEntity> page = this.selectPage(
                new Query<SurgeryEntity>(params).getPage(),
                new EntityWrapper<SurgeryEntity>()
        );

        return new PageUtils(page);
    }

}
