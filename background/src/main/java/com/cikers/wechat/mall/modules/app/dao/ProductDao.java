package com.cikers.wechat.mall.modules.app.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cikers.wechat.mall.modules.app.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hwp
 * @email weiping_david@foxmail.com
 * @date 2018-06-10 15:14:01
 */
@Mapper
@Component(value = "ProductDao")
public interface ProductDao extends BaseMapper<ProductEntity> {
    int truncate();

    List<ProductEntity> getProductByEqptId(Long eqptId);
}
