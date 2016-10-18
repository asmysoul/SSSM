/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.service.impl
 *
 *    Filename:    SysLogServiceImpl.java
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
 *    Create at:   2016年10月18日 下午3:10:17
 *
 *    Revision:
 *
 *    2016年10月18日 下午3:10:17
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.mapper.SysLogMapper;
import top.fzqblog.po.model.SysLog;
import top.fzqblog.po.query.SysLogQuery;
import top.fzqblog.service.SysLogService;

/**
 * @ClassName SysLogServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年10月18日 下午3:10:17
 * @version 1.0.0
 */
@Service
public class SysLogServiceImpl implements SysLogService {


	@Autowired
	private SysLogMapper<SysLog, SysLogQuery> sysLogMapper;
	
	public void addSysLog(SysLog sysLog) {
		this.sysLogMapper.insert(sysLog);
	}

}
