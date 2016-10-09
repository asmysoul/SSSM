/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.service
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
 *    Create at:   2016年10月9日 上午10:24:04
 *
 *    Revision:
 *
 *    2016年10月9日 上午10:24:04
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service;

import java.util.List;
import java.util.Set;

import top.fzqblog.po.vo.Tree;
import top.fzqblog.shiro.ShiroUser;

/**
 * @ClassName ResourceService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月9日 上午10:24:04
 * @version 1.0.0
 */
public interface ResourceService {
	public List<Tree> findMenu(ShiroUser shiroUser);
}
