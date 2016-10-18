/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.po.query
 *
 *    Filename:    SysLogQuery.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     fzqblog
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年10月18日 下午3:12:12
 *
 *    Revision:
 *
 *    2016年10月18日 下午3:12:12
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.query;

/**
 * @ClassName SysLogQuery
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月18日 下午3:12:12
 * @version 1.0.0
 */
public class SysLogQuery extends BaseQuery{
	
	private Long id;
	
	private String loginName;

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
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
	
	
	
}
