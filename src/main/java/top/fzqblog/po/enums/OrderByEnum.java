/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.po.enums
 *
 *    Filename:    OrderByEnum.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月9日 上午10:04:28
 *
 *    Revision:
 *
 *    2016年10月9日 上午10:04:28
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.enums;

/**
 * @ClassName OrderByEnum
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 上午10:04:28
 * @version 1.0.0
 */
public enum OrderByEnum {
	ORDER_BY_SEQ("order by seq asc", "根据seq升序排列");
	
	private String orderby;
	
	private String desc;

	/**
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @param orderby
	 * @param desc
	 */
	private OrderByEnum(String orderby, String desc) {
		this.orderby = orderby;
		this.desc = desc;
	}

	/**
	 * @return the orderby
	 */
	public String getOrderby() {
		return orderby;
	}

	/**
	 * @param orderby the orderby to set
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
