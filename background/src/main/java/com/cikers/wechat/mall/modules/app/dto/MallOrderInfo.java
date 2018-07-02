/** 
 * MallOrderInfo.java Create on 2018年5月29日
 * www.cikers.com. 
 */ 


package com.cikers.wechat.mall.modules.app.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * 商城订单信息
 *
 * @author WangXP
 * @version 1.0
 * @date 2018年5月29日
 */
public class MallOrderInfo implements Serializable {
	private List<ProductItem> items;

	public List<ProductItem> getItems() {
		return items;
	}

	public void setItems(List<ProductItem> items) {
		this.items = items;
	}

	/**
	 * 商品项
	 * @author WangXP
	 * @version 1.0
	 * @date 2018年5月29日
	 */
	public static class ProductItem {
		/** 商品 ID */
		private Long id;
		/** 购买数量 */
		private Integer count;
	}

	public static MallOrderInfo parse(String order) {
		try {
			return JSONObject.parseObject(order, MallOrderInfo.class);
		} catch (Exception e) {
			throw new RuntimeException(order + "请求参数 json 解析失败");
		}
	}
}
