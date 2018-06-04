package com.cikers.wechat.mall.modules.business.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;

import com.cikers.wechat.mall.modules.business.dao.EvaluationDao;
import com.cikers.wechat.mall.modules.business.entity.EvaluationEntity;
import com.cikers.wechat.mall.modules.business.service.EvaluationService;


@Service("evaluationService")
public class EvaluationServiceImpl extends ServiceImpl<EvaluationDao, EvaluationEntity> implements EvaluationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EvaluationEntity> page = this.selectPage(
                new Query<EvaluationEntity>(params).getPage(),
                new EntityWrapper<EvaluationEntity>()
        );

        return new PageUtils(page);
    }

}
