package com.cikers.wechat.mall.modules.app.controller;

import com.cikers.api.vo.EqptDTO;
import com.cikers.api.vo.EqptProduct;
import com.cikers.wechat.mall.common.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WeiPing He on 2018/6/4 01:22.
 * Email: weiping_he@hansight.com
 */
@RestController
@RequestMapping("/wechat/products")
@Api(description = "微信商城", basePath = "/wechat/products")
@Slf4j
public class AppProductController {


    @Autowired
    private RestTemplate restTemplate;

    private List<EqptProduct> allProducts = new ArrayList<>();

    /**
     * 获得赛克商品数据
     */
    @GetMapping()
//    @ApiOperation("获得商品")
    @ApiOperation(value = "获得商品", response = R.class)
    public R products() {
        if (allProducts.isEmpty()) {
            //拼接参数
            String url = "http://newstack.cikers.com:10422/mall/v1.0/products/";
            //get json数据
            EqptDTO product = restTemplate.getForEntity(url, EqptDTO.class).getBody();
            log.info("赛克商品接口返回：{}", product.getData().size());

            if (product.getE() != 0 && product.getMsg() != null) {
                //返回异常信息
                return R.error(product.getMsg());
            }

            allProducts = product.getData();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("product", allProducts);

        return R.ok(map);
    }
}
