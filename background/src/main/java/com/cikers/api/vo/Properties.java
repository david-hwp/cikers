/** 
 * Properties.java Create on 2018年5月9日
 * www.cikers.com. 
 */

package com.cikers.api.vo;

/**
 * 
 *
 * @author WangXP
 * @version 1.0
 * @date 2018年5月9日
 */
public class Properties {
	/** ID */
	private Long id;
	/** 属性说明 */
	private String desc;

	public Properties() {}

	public Properties(Properties prop) {
		super();
		this.id = prop.getId().longValue();
		this.desc = prop.getDesc();
	}

	public Properties(Long id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
