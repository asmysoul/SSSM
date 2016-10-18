/******************************************************************
 *
 *    
 *
 *    Copyright (c) 2016-forever 
 *    http://www.fzqblog.top
 *
 *    Package:     top.fzqblog.scan
 *
 *    Filename:    SysLogAspect.java
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
 *    Create at:   2016年10月18日 下午3:08:19
 *
 *    Revision:
 *
 *    2016年10月18日 下午3:08:19
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.scan;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import top.fzqblog.po.model.SysLog;
import top.fzqblog.service.SysLogService;
import top.fzqblog.utils.StringUtils;



/**
 * @ClassName SysLogAspect
 * @Description aop日志记录
 * @author 抽离
 * @Date 2016年10月18日 下午3:08:19
 * @version 1.0.0
 */
@Aspect
@Component
public class SysLogAspect {

	 private static final Logger LOGGER = LogManager.getLogger(SysLogAspect.class);
	 
	    @Autowired
	    private SysLogService sysLogService;
	    
	    @Pointcut("within(@org.springframework.stereotype.Controller *)")
	    public void cutController() {}
	    
	    
	    @Around("cutController()")
	    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
	    	 String strMethodName = point.getSignature().getName();
	         String strClassName = point.getTarget().getClass().getName();
	         Object[] params = point.getArgs();
	         StringBuffer bfParams = new StringBuffer();
	         Enumeration<String> paraNames = null;
	         HttpServletRequest request = null;
	         if (params != null && params.length > 0) {
	             request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	             paraNames = request.getParameterNames();
	             String key;
	             String value;
	             while (paraNames.hasMoreElements()) {
	                 key = paraNames.nextElement();
	                 value = request.getParameter(key);
	                 bfParams.append(key).append("=").append(value).append("&");
	             }
	             if (StringUtils.isEmpty(bfParams.toString())) {
	                 bfParams.append(request.getQueryString());
	             }
	         }

	         String strMessage = String
	                 .format("[类名]:%s,[方法]:%s,[参数]:%s", strClassName, strMethodName, bfParams.toString());
	         LOGGER.info(strMessage);
	         if (isWriteLog(strMethodName)) {
	             try {
	                 Subject currentUser = SecurityUtils.getSubject();
	                 PrincipalCollection collection = currentUser.getPrincipals();
	                 if (null != collection) {
	                     String loginName = collection.getPrimaryPrincipal().toString();
	                     SysLog sysLog = new SysLog();
	                     sysLog.setLoginName(loginName);
	                     sysLog.setRoleName(loginName);
	                     sysLog.setOpContent(strMessage);
	                     sysLog.setCreateTime(new Date());
	                     if (request != null) {
	                         sysLog.setClientIp(request.getRemoteAddr());
	                     }
	                     LOGGER.info(sysLog.toString());
	                     sysLogService.addSysLog(sysLog);
	                 }
	             } catch (Exception e) {
	                 e.printStackTrace();
	             }
	         }

	         return point.proceed();
	    	
	    }
	    
	    private boolean isWriteLog(String method) {
	        String[] pattern = {"postLogin", "login", "logout", "add", "edit", "delete", "grant"};
	        for (String s : pattern) {
	            if (method.indexOf(s) > -1) {
	                return true;
	            }
	        }
	        return false;
	    }
	
}
