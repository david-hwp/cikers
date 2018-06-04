package com.cikers.wechat.mall.modules.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.cikers.wechat.mall.common.utils.PageUtils;
import com.cikers.wechat.mall.modules.business.entity.DictionaryEntity;

import java.util.Map;

/**
 * 字典信息
 *
 * @author hjk
 * @email 358236647@qq.com
 * @date 2018-04-19 20:26:15
 */
public interface DictionaryService extends IService<DictionaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

