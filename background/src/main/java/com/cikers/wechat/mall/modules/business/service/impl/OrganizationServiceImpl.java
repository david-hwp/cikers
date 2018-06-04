package com.cikers.wechat.mall.modules.business.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;

import com.cikers.wechat.mall.modules.business.dao.OrganizationDao;
import com.cikers.wechat.mall.modules.business.entity.OrganizationEntity;
import com.cikers.wechat.mall.modules.business.service.OrganizationService;


@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationDao, OrganizationEntity> implements OrganizationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrganizationEntity> page = this.selectPage(
                new Query<OrganizationEntity>(params).getPage(),
                new EntityWrapper<OrganizationEntity>()
        );

        return new PageUtils(page);
    }

}
