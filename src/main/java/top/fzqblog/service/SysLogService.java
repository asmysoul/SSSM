/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.service
 *
 *    Filename:    SysLogService.java
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
 *    Create at:   2016年10月18日 下午3:09:38
 *
 *    Revision:
 *
 *    2016年10月18日 下午3:09:38
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service;

import top.fzqblog.po.model.SysLog;

/**
 * @ClassName SysLogService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月18日 下午3:09:38
 * @version 1.0.0
 */
public interface SysLogService {
	
	public void addSysLog(SysLog sysLog);
}
