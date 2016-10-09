/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.po.query
 *
 *    Filename:    ResourceQuery.java
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
 *    Create at:   2016年10月9日 上午10:15:24
 *
 *    Revision:
 *
 *    2016年10月9日 上午10:15:24
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.query;

import top.fzqblog.po.enums.OrderByEnum;

/**
 * @ClassName ResourceQuery
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 上午10:15:24
 * @version 1.0.0
 */
public class ResourceQuery extends BaseQuery {
	private Long id;
	
	private OrderByEnum orderBy;
	
	private Long pid;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	



	/**
	 * @return the orderBy
	 */
	public OrderByEnum getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy the orderBy to set
	 */
	public void setOrderBy(OrderByEnum orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}

	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}
	
	
}
