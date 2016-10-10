/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.controller
 *
 *    Filename:    RoleController.java
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
 *    Create at:   2016年10月9日 下午4:45:59
 *
 *    Revision:
 *
 *    2016年10月9日 下午4:45:59
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.fzqblog.po.model.Role;
import top.fzqblog.service.ResourceService;
import top.fzqblog.service.RoleService;

/**
 * @ClassName RoleController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 下午4:45:59
 * @version 1.0.0
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/manager")
	public String Role(){
		return "/page/role/role";
	}
	
	@ResponseBody
	@RequestMapping("/roleData")
	public Object roleData(Integer page, Integer rows){
		return this.roleService.findRolesByPage(page, rows);
	}
	
	@ResponseBody
	@RequestMapping("findAllTree")
	public Object findAllTree(){
		return this.resourceService.findAllTree();
	}
	
	@ResponseBody
	@RequestMapping("findResourceIdListByRoleId")
	public Object findResourceIdListByRoleId(Long id){
		return renderSuccess(this.roleService.findResourceIdListByRoleId(id));
	}
}
