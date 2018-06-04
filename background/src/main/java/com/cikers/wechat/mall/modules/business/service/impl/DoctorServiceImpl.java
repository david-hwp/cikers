package com.cikers.wechat.mall.modules.business.service.impl;

import com.cikers.wechat.mall.modules.business.dao.DoctorDao;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;

import com.cikers.wechat.mall.modules.business.entity.DoctorEntity;
import com.cikers.wechat.mall.modules.business.service.DoctorService;


@Service("doctorService")
public class DoctorServiceImpl extends ServiceImpl<DoctorDao, DoctorEntity> implements DoctorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DoctorEntity> page = this.selectPage(
                new Query<DoctorEntity>(params).getPage(),
                new EntityWrapper<DoctorEntity>()
        );

        return new PageUtils(page);
    }

}
