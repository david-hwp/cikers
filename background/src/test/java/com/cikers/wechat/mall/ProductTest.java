package com.cikers.wechat.mall;


import com.cikers.wechat.mall.modules.app.entity.ProductEntity;
import com.cikers.wechat.mall.modules.app.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductService productService;

    @Test
    public void getProduct() {
        List<ProductEntity> productEntities = productService.getProductByEqptId(1L);
        System.out.println(productEntities);
    }

}
