/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.service.impl
 *
 *    Filename:    RoleServiceImpl.java
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
 *    Create at:   2016年10月8日 下午2:56:24
 *
 *    Revision:
 *
 *    2016年10月8日 下午2:56:24
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.mapper.RoleMapper;
import top.fzqblog.po.enums.OrderByEnum;
import top.fzqblog.po.model.Role;
import top.fzqblog.po.query.RoleQuery;
import top.fzqblog.po.vo.PageResult;
import top.fzqblog.service.RoleService;
import top.fzqblog.utils.Page;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月8日 下午2:56:24
 * @version 1.0.0
 */

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper<Role, RoleQuery> roleMapper;

	/* (非 Javadoc)
	 * Description:
	 * @see top.fzqblog.service.RoleService#findResourceListByRoleId(java.util.Set)
	 */
	public Set<String> findResourceListByRoleId(Set<Long> roleIds) {
		return this.roleMapper.selectResourceListByRoleId(roleIds);
	}

	/* (非 Javadoc)
	 * Description:
	 * @see top.fzqblog.service.RoleService#findRolesByPage()
	 */
	public PageResult findRolesByPage(Integer page, Integer rows) {
		RoleQuery roleQuery = new RoleQuery();
		Long count = this.roleMapper.selectCount(roleQuery);
		Integer pageNum  = rows==null?  10 : rows;
		Page myPage = new Page(page, count, pageNum);
		roleQuery.setPage(myPage);
		roleQuery.setOrderBy(OrderByEnum.ORDER_BY_SEQ);
		List<Role> list = this.roleMapper.selectList(roleQuery);
		return new PageResult(count.intValue(),list);
	}

}
