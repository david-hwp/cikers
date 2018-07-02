package com.cikers.wechat.mall.modules.app.controller;

import com.cikers.wechat.mall.common.utils.BaseResp;
import com.cikers.wechat.mall.modules.app.dto.EquipmentDTO;
import com.cikers.wechat.mall.modules.app.entity.EquipmentEntity;
import com.cikers.wechat.mall.modules.app.entity.ProductEntity;
import com.cikers.wechat.mall.modules.app.entity.PropertyEntity;
import com.cikers.wechat.mall.modules.app.entity.PropertyRelationEntity;
import com.cikers.wechat.mall.modules.app.form.ProductForm;
import com.cikers.wechat.mall.modules.app.service.EquipmentService;
import com.cikers.wechat.mall.modules.app.service.ProductService;
import com.cikers.wechat.mall.modules.app.service.PropertyRelationService;
import com.cikers.wechat.mall.modules.app.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WeiPing He on 2018/6/4 01:22.
 * Email: weiping_he@hansight.com
 */
@Slf4j
@Api(value = "商品操作", tags = {"商品的查询"})
@RestController
@RequestMapping("/wechat/products")
@ConfigurationProperties(prefix = "cikers.server")
public class AppProductController {


    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyRelationService propertyRelationService;

    private String host;

    @PostMapping(value = "list", produces = "application/json")
//    @ApiOperation("获得商品")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "body", dataType = "String", name = "keyword", value = "用户搜索的关键字", required = false),
//            @ApiImplicitParam(paramType = "body", dataType = "String", name = "type", value = "商品类型", required = false),
//            @ApiImplicitParam(paramType = "body", dataType = "int", name = "pageSize", value = "页大小", required = true),
//            @ApiImplicitParam(paramType = "body", dataType = "int", name = "pageIndex", value = "页码", required = true),
//    })
    @ApiOperation(value = "获得商品列表", produces = "application/json")
    @ResponseBody
    public BaseResp products(@RequestBody ProductForm productForm) {
        log.debug(productForm.toString());
        if (productForm.getPageIndex() == null) {
            productForm.setPageIndex(1);
        }
        if (productForm.getPageSize() == null) {
            productForm.setPageSize(10);
        }

        return BaseResp.ok(equipmentService.queryList(productForm));

//        if (allProducts.isEmpty()) {
//            //拼接参数
//            String url = host + version + "/products/";
//
//            //get json数据
//            EquipmentDTO product = restTemplate.getForEntity(url, EquipmentDTO.class).getBody();
//            log.info("赛克商品接口返回：{}", product.getData().size());
//
//            if (product.getE() != 0 && product.getMsg() != null) {
//                //返回异常信息
//                return BaseResp.error(product.getMsg());
//            }
//
//            allProducts = product.getData();
//        }
//        return BaseResp.ok().put("product", allProducts);
    }

    @GetMapping(value = "update", produces = "application/json")
    @ApiOperation(value = "商品列表更新接口", produces = "application/json")
    @ResponseBody
    public BaseResp update() {
        try {
            //拼接参数
            String url = host + "/products";
            //get json数据
//            restTemplate.get
            EquipmentDTO equipmentDTO = restTemplate.getForObject(url, EquipmentDTO.class);
            log.info("赛克商品接口返回商品数据量：{}", equipmentDTO.getData().size());
            propertyRelationService.truncate();
            propertyService.truncate();
            productService.truncate();
            equipmentService.truncate();
            Map<Long, PropertyEntity> properties = new HashMap<>();
            List<EquipmentEntity> equipmentEntities = equipmentDTO.getData();
            for (EquipmentEntity equipmentEntity : equipmentEntities) {
                List<ProductEntity> products = equipmentEntity.getProudcts();
                for (ProductEntity product : products) {
                    Map<String, PropertyEntity> props = product.getProps();
                    for (String s : props.keySet()) {
                        PropertyEntity propertyEntity = props.get(s);
                        properties.put(propertyEntity.getId(), propertyEntity);
//                        propertyService.insert(propertyEntity);
                        PropertyRelationEntity propertyRelationEntity = new PropertyRelationEntity();
                        propertyRelationEntity.setProductId(product.getId());
                        propertyRelationEntity.setPropertyName(s);
                        propertyRelationEntity.setPropertyId(propertyEntity.getId());
                        propertyRelationService.insert(propertyRelationEntity);
                    }
                    productService.insert(product);
                }
                Map<String, PropertyEntity> props = equipmentEntity.getProps();
                for (String s : props.keySet()) {
                    PropertyEntity propertyEntity = props.get(s);
                    properties.put(propertyEntity.getId(), propertyEntity);
//                    propertyService.insert(propertyEntity);
                    PropertyRelationEntity propertyRelationEntity = new PropertyRelationEntity();
                    propertyRelationEntity.setEquipmentId(equipmentEntity.getId());
                    propertyRelationEntity.setPropertyName(s);
                    propertyRelationEntity.setPropertyId(propertyEntity.getId());
                    propertyRelationService.insert(propertyRelationEntity);
                }
                equipmentService.insert(equipmentEntity);
            }

            for (Long id : properties.keySet()) {
                propertyService.insert(properties.get(id));
            }
        } catch (Exception e) {
            return BaseResp.error(e.getMessage());
        }

        return BaseResp.ok();
    }


    @GetMapping(value = "group", produces = "application/json")
    @ApiOperation(value = "获取商品分组信息", produces = "application/json")
    @ResponseBody
    public BaseResp group() {
        try {
            List<PropertyEntity> propertyEntities = propertyService.queryTypes();
            return BaseResp.ok(propertyEntities);
        } catch (Exception e) {
            return BaseResp.error(e.getMessage());
        }
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}
