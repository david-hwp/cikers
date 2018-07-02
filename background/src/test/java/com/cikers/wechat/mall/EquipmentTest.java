package com.cikers.wechat.mall;


import com.alibaba.fastjson.JSON;
import com.cikers.wechat.mall.modules.app.dto.EquipmentDTO;
import com.cikers.wechat.mall.modules.app.entity.EquipmentEntity;
import com.cikers.wechat.mall.modules.app.form.ProductForm;
import com.cikers.wechat.mall.modules.app.service.EquipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipmentTest {

    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void insertEqpt() {
        String json = "{\"id\":1,\"props\":{\"SPORT\":{\"id\":3,\"value\":\"soccer\",\"desc\":\"足球\"},\"SERIES\":{\"id\":36,\"value\":\"dragonvein\",\"desc\":\"龙脉\"},\"SECONDARYCOLOR\":{\"id\":155,\"value\":\"brown\",\"desc\":\"棕红色\"},\"STYLE\":{\"id\":56,\"value\":\"first\",\"desc\":\"第一代\"},\"CROWD\":{\"id\":108,\"value\":\"male\",\"desc\":\"男\"},\"TYPE\":{\"id\":4,\"value\":\"S201\",\"desc\":\"短袖比赛服\"},\"MAINCOLOR\":{\"id\":156,\"value\":\"red\",\"desc\":\"红色\"},\"MATERIAL\":{\"id\":112,\"value\":\"AA\",\"desc\":\"速干\"},\"BRAND\":{\"id\":1,\"value\":\"ai\",\"desc\":\"AI\"}},\"proudcts\":[{\"id\":1,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB3A\",\"dispOrder\":10,\"props\":{\"SHAPE\":{\"id\":152,\"value\":\"fitted\",\"desc\":\"修身\"},\"SIZE\":{\"id\":142,\"value\":\"S\",\"desc\":\"S\"}}},{\"id\":2,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB3B\",\"dispOrder\":20,\"props\":{\"SHAPE\":{\"id\":153,\"value\":\"straight\",\"desc\":\"宽松\"},\"SIZE\":{\"id\":142,\"value\":\"S\",\"desc\":\"S\"}}},{\"id\":3,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB4A\",\"dispOrder\":30,\"props\":{\"SHAPE\":{\"id\":152,\"value\":\"fitted\",\"desc\":\"修身\"},\"SIZE\":{\"id\":143,\"value\":\"M\",\"desc\":\"M\"}}},{\"id\":4,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB4B\",\"dispOrder\":40,\"props\":{\"SHAPE\":{\"id\":153,\"value\":\"straight\",\"desc\":\"宽松\"},\"SIZE\":{\"id\":143,\"value\":\"M\",\"desc\":\"M\"}}},{\"id\":5,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB5A\",\"dispOrder\":50,\"props\":{\"SHAPE\":{\"id\":152,\"value\":\"fitted\",\"desc\":\"修身\"},\"SIZE\":{\"id\":144,\"value\":\"L\",\"desc\":\"L\"}}},{\"id\":6,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB5B\",\"dispOrder\":60,\"props\":{\"SHAPE\":{\"id\":153,\"value\":\"straight\",\"desc\":\"宽松\"},\"SIZE\":{\"id\":144,\"value\":\"L\",\"desc\":\"L\"}}},{\"id\":7,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB6A\",\"dispOrder\":70,\"props\":{\"SHAPE\":{\"id\":152,\"value\":\"fitted\",\"desc\":\"修身\"},\"SIZE\":{\"id\":145,\"value\":\"XL\",\"desc\":\"XL\"}}},{\"id\":8,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB6B\",\"dispOrder\":80,\"props\":{\"SHAPE\":{\"id\":153,\"value\":\"straight\",\"desc\":\"宽松\"},\"SIZE\":{\"id\":145,\"value\":\"XL\",\"desc\":\"XL\"}}},{\"id\":9,\"eqptId\":1,\"articleNo\":\"C17S201AAZ1CB7B\",\"dispOrder\":90,\"props\":{\"SHAPE\":{\"id\":153,\"value\":\"straight\",\"desc\":\"宽松\"},\"SIZE\":{\"id\":146,\"value\":\"XXL\",\"desc\":\"XXL\"}}}],\"articleNumber\":\"C17S201AAZ1\",\"imgURL\":\"/cs/equipment/ai/soccer/S201_dragonvein_first_red_male_AA_CB_1.jpg\",\"descURL\":\"http://mp.weixin.qq.com/s/5XVeLKzWmJZRrqQhUOx3PA\"}";
        EquipmentEntity equipmentEntity = JSON.parseObject(json, EquipmentEntity.class);
        System.out.println(equipmentEntity);
        equipmentService.insert(equipmentEntity);
    }

    @Test
    public void getEqpt() {
        ProductForm productForm = new ProductForm();
        productForm.setPageSize(5);
        productForm.setPageIndex(2);
//        productForm.setKeyword("足球");
//        productForm.setType("短袖比赛服");
        List<EquipmentEntity> equipmentEntities = equipmentService.queryList(productForm);
        System.out.println(equipmentEntities);
    }

    @Test
    public void update() {

        EquipmentDTO equipmentDTO = restTemplate.getForObject("http://newstack.cikers.com:10422/mall/v1.0/products", EquipmentDTO.class);
        System.out.println(equipmentDTO.getData().size());
    }

}
