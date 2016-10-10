/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.service
 *
 *    Filename:    RoleService.java
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
 *    Create at:   2016年10月8日 下午2:55:18
 *
 *    Revision:
 *
 *    2016年10月8日 下午2:55:18
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service;

import java.util.List;
import java.util.Set;

import top.fzqblog.po.model.Role;
import top.fzqblog.po.vo.PageResult;

/**
 * @ClassName RoleService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月8日 下午2:55:18
 * @version 1.0.0
 */
public interface RoleService {
	public Set<String> findResourceListByRoleId(Set<Long> roleIds);
	
	public Set<Long> findResourceIdListByRoleId(Long roleId);
	
	public PageResult findRolesByPage(Integer page, Integer rows);
}
