package com.cikers.wechat.mall.modules.business.service.impl;

import com.cikers.wechat.mall.common.utils.Query;
import com.cikers.wechat.mall.modules.business.dao.ReceiveDoctorDao;
import com.cikers.wechat.mall.modules.business.entity.ReceiveDoctorEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;

import com.cikers.wechat.mall.modules.business.service.ReceiveDoctorService;


@Service("receiveDoctorService")
public class ReceiveDoctorServiceImpl extends ServiceImpl<ReceiveDoctorDao, ReceiveDoctorEntity> implements ReceiveDoctorService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReceiveDoctorEntity> page = this.selectPage(
                new Query<ReceiveDoctorEntity>(params).getPage(),
                new EntityWrapper<ReceiveDoctorEntity>()
        );

        return new PageUtils(page);
    }

}
