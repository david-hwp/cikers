package com.cikers.wechat.mall.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商品属性表
 *
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
@Mapper
public interface PropertyDao extends BaseMapper<PropertyEntity> {
    int truncate();

    List<PropertyEntity> queryTypes();
}
