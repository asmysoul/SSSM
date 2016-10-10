/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.service
 *
 *    Filename:    UserServiceTest.java
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
 *    Create at:   2016年10月4日 上午12:21:50
 *
 *    Revision:
 *
 *    2016年10月4日 上午12:21:50
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import bsh.This;

/**
 * @ClassName UserServiceTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月4日 上午12:21:50
 * @version 1.0.0
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ResourceServiceTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	

	
	
	
	@Test
	public void testFindUserByLoginname(){
		System.out.println(userService.findUserByLoginName("123").getPassword());
	}
	
	@Test
	public void testSelectRoleIdsByUserId(){
		Set<Long> roleSet = this.userService.findRoleIdsByUserId(1);
	}
	
	@Test
	public void testFindAllTree(){
		System.out.println(this.resourceService.findAllTree());
	}
}
