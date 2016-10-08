/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.po.query
 *
 *    Filename:    UserRoleQuery.java
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
 *    Create at:   2016年10月6日 下午9:11:31
 *
 *    Revision:
 *
 *    2016年10月6日 下午9:11:31
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.po.query;

/**
 * @ClassName UserRoleQuery
 * @Description 用户角色查询条件类
 * @author 抽离
 * @Date 2016年10月6日 下午9:11:31
 * @version 1.0.0
 */
public class UserRoleQuery extends BaseQuery {
	
	private Long id;
	
	private Long userId;
	
	private Long roleId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}
