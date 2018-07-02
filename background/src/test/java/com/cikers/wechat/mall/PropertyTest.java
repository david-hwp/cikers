package com.cikers.wechat.mall;


import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import com.cikers.wechat.mall.modules.app.service.PropertyRelationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyTest {

    @Autowired
    private PropertyRelationService propertyRelationService;

    @Test
    public void getPropertyMap() {
        Map<String, PropertyEntity> propertyEntityMap = propertyRelationService.selectByEqptId(1L);
//        Map<String, PropertyEntity> propertyEntityMap = propertyRelationService.selectByProductId(1L);
        System.out.println(propertyEntityMap);
    }

}
