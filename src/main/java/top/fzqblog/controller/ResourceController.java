/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.controller
 *
 *    Filename:    ResourceController.java
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
 *    Create at:   2016年10月9日 上午11:21:05
 *
 *    Revision:
 *
 *    2016年10月9日 上午11:21:05
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.fzqblog.service.ResourceService;

/**
 * @ClassName ResourceController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 上午11:21:05
 * @version 1.0.0
 */
@Controller
public class ResourceController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
	
	@ResponseBody
	@RequestMapping("/menu")
	public Object menu(){
		return this.resourceService.findMenu(getShiroUser());
	}
}
