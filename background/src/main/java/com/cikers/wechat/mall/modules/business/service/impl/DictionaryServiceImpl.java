package com.cikers.wechat.mall.modules.business.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.common.utils.Query;

import com.cikers.wechat.mall.modules.business.dao.DictionaryDao;
import com.cikers.wechat.mall.modules.business.entity.DictionaryEntity;
import com.cikers.wechat.mall.modules.business.service.DictionaryService;


@Service("dictionaryService")
public class DictionaryServiceImpl extends ServiceImpl<DictionaryDao, DictionaryEntity> implements DictionaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DictionaryEntity> page = this.selectPage(
                new Query<DictionaryEntity>(params).getPage(),
                new EntityWrapper<DictionaryEntity>()
        );

        return new PageUtils(page);
    }

}
