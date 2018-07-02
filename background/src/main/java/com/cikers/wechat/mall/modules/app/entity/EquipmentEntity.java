/**
 * EquipmentEntity.java Create on 2018-5-11
 * www.cikers.com.
 */


package com.cikers.wechat.mall.modules.app.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 装备产品
 *
 * @author WangXP
 * @version 1.0
 * @date 2018-5-11
 */
@Data
@TableName("tb_equipment")
public class EquipmentEntity {


    @TableId
    private long id;
    /**
     * 装备的尺码、版型列表
     */
//    @TableField(exist=false)
    private List<ProductEntity> proudcts = new LinkedList<>();
    private String articleNumber;
    private String imgURL;
    private Double price;
    private String descURL;
    /**
     * 属性集
     * 品牌：brand
     * 运动类型： sport
     * 款式： type
     * 系列： series
     * 样式： style
     * 适用人群： crowd
     * 材质： material
     */
    @TableField(exist = false)
    private Map<String, PropertyEntity> props = new HashMap<>();

}