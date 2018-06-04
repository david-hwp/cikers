/** 
 * EqptProduct.java Create on 2018-5-11
 * www.cikers.com. 
 */ 


package com.cikers.api.vo;

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
public class EqptProduct {

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
	private Map<String, Properties> props = new HashMap<>();
	/** 装备的尺码、版型列表 */
	private List<Product> proudcts = new LinkedList<>();
	private String articleNumber;
	private String imgURL;
	private String descURL;

//
//	@Override
//	public AbstractBaseInfo getBaseInfo() {
//		CMallBaseInfo info = new CMallBaseInfo();
//		info.setId(getId());
//		info.setIcon(getImgURL());
//
//		String series = props.get(SERIES).getDesc();
//		String type = props.get(SERIES).getDesc();
//		String style = props.get(STYLE).getDesc();
//		final String name = new StringBuilder(series)
//			.append(" ").append(type)
//			.append(" ").append(style)
//			.toString();
//		info.setName(name);
//
//		String brand = props.get(BRAND).getDesc();
//		String sport = props.get(SPORT).getDesc();
//		final String brandInfo = new StringBuilder(brand)
//			.append(" ").append(sport)
//			.toString();
//		info.setBrand(brandInfo);
//
//		String crowd = props.get(CROWD).getDesc();
//		info.setCrowd(crowd);
//
//		List<Properties> colors = new ArrayList<>(getProudcts().size());
//		for (Product item : getProudcts()) {
//			final Properties mainColor = item.getProps().get(MAINCOLOR);
//			Properties colorProp = new Properties(mainColor);
//			colors.add(mainColor);
//		}
//		
//		// TODO 颜色排序
//		info.setColors(colors);
//		return info;
//	}
//
//	@Override
//	public AbstractDetailPageInfo getDetailPageInfo(Long crowd) {
//		CMailDetailPageInfo info = new CMailDetailPageInfo();
//		List<DetailInfo> infos = new ArrayList<>();
//		
//		return null;
//	}
//
//	@Override
//	public AbstractStockInfo getStockInfo() {
//		return null;
//	}

	public Map<String, Properties> getProps() {
		return props;
	}

	public void setProps(Map<String, Properties> props) {
		this.props = props;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public List<Product> getProudcts() {
		return proudcts;
	}

	public void setProudcts(List<Product> proudcts) {
		this.proudcts = proudcts;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getDescURL() {
		return descURL;
	}

	public void setDescURL(String descURL) {
		this.descURL = descURL;
	}
}
