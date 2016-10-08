package top.fzqblog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import top.fzqblog.po.model.User;
import top.fzqblog.po.vo.Result;
import top.fzqblog.service.UserService;
import top.fzqblog.shiro.ShiroUser;

@Controller
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @Description ajax返回错误信息
	 * @param msg
	 * @return
	 */
	public Object renderError(String msg){
		Result result = new Result();
		result.setMsg(msg);
		return result;
	}
	
	/**
	 * 
	 * @Description ajax请求成功返回
	 * @return
	 */
	public Object renderSuccess(){
		Result result = new Result();
		result.setSuccess(true);
		return result;
	}
	
	/**
	 * 
	 * @Description ajax成功带提示信息返回
	 * @param msg
	 * @return
	 */
	public Object renderSuccess(String msg){
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(msg);
		return result;
	}
	
	/**
	 * 
	 * @Description ajax成功带数据返回
	 * @param data
	 * @return
	 */
	public Object renderSuccess(Object data){
		Result result = new Result();
		result.setSuccess(true);
		result.setData(data);
		return result;
	}
	
	/**
	 * 
	 * @Description 返回session中的User
	 * @return
	 */
	public User getCurrentUser(){
		Subject subject = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
		return userService.findUserById(shiroUser.id);
	}
	
	/**
	 * 
	 * @Description 得到当前登录用户的ID
	 * @return
	 */
	public Long getUserId(){
		return this.getCurrentUser().getId();
	}
}
