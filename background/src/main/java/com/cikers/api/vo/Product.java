/**
 * Product.java Create on 2018年5月9日
 * www.cikers.com.
 */

package com.cikers.api.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品详情
 *
 * @author WangXP
 * @version 1.0
 * @date 2018年5月9日
 */
public class Product {
    /** ID */
    private Long id;
    /** Equipment ID */
    private Long eqptId;
    /** 编码 */
    private String articleNo;
    /** 排序 */
    private Integer dispOrder;

    /**
     * 、属性集
     *  尺码： size
     *  版型： shape
     */
    private Map<String, Properties> props = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEqptId() {
        return eqptId;
    }

    public void setEqptId(Long eqptId) {
        this.eqptId = eqptId;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public Integer getDispOrder() {
        return dispOrder;
    }

    public void setDispOrder(Integer dispOrder) {
        this.dispOrder = dispOrder;
    }

    public Map<String, Properties> getProps() {
        return props;
    }

    public void setProps(Map<String, Properties> props) {
        this.props = props;
    }
}
