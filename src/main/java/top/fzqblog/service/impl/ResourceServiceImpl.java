/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.service.impl
 *
 *    Filename:    ResourceService.java
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
 *    Create at:   2016年10月9日 上午10:25:49
 *
 *    Revision:
 *
 *    2016年10月9日 上午10:25:49
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.mapper.ResourceMapper;
import top.fzqblog.po.enums.ResourceType;
import top.fzqblog.po.model.Resource;
import top.fzqblog.po.query.ResourceQuery;
import top.fzqblog.po.vo.Tree;
import top.fzqblog.service.ResourceService;
import top.fzqblog.shiro.ShiroUser;

/**
 * @ClassName ResourceService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 上午10:25:49
 * @version 1.0.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper<Resource, ResourceQuery> resourceMapper;
	
	public List<Tree> findMenu(ShiroUser shiroUser) {
		List<Tree> firstTreeList = new ArrayList<Tree>();
		Set<Long> roleIds = shiroUser.roleSet;
		List<Resource> firstResourceList = this.resourceMapper.selectMenuByRoleId(roleIds, ResourceType.RESOURCE_MENU.getType());
		for(Resource resource : firstResourceList){
			Tree tree = new Tree();
			tree.setId(resource.getId());
			tree.setText(resource.getName());
			tree.setIconCls(resource.getIcon());
			tree.setAttributes(resource.getUrl());
			List<Tree> sencondTreeList = new ArrayList<Tree>();
			List<Resource> secondResourceList = this.resourceMapper.selectMenuByRoleIdAndPid(roleIds, ResourceType.RESOURCE_MENU.getType(), resource.getId());
			for(Resource secondsecond : secondResourceList){
				Tree secondtree = new Tree();
				secondtree.setId(secondsecond.getId());
				secondtree.setText(secondsecond.getName());
				secondtree.setIconCls(secondsecond.getIcon());
				secondtree.setAttributes(secondsecond.getUrl());
				sencondTreeList.add(secondtree);
			}
			tree.setChildren(sencondTreeList);
			firstTreeList.add(tree);
		}
		return firstTreeList;
	}

}
