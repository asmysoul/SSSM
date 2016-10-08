/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.po.query
 *
 *    Filename:    RoleResourceQuery.java
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
 *    Create at:   2016年10月6日 下午10:04:18
 *
 *    Revision:
 *
 *    2016年10月6日 下午10:04:18
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.query;

/**
 * @ClassName RoleResourceQuery
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月6日 下午10:04:18
 * @version 1.0.0
 */
public class RoleResourceQuery extends BaseQuery {
	
	private Long id;
	
	private Long roleId;
	
	private Long resourceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	
	
}
