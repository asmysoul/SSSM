package top.fzqblog.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.sql.dialect.oracle.ast.clause.ModelClause.ReturnRowsClause;

import top.fzqblog.service.UserService;
import top.fzqblog.utils.StringUtils;

@Controller
public class LoginController extends BaseController{
	
	public static final Logger LOGGER = LogManager.getLogger(LoginController.class);

	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(){
		LOGGER.info("GET登录");
		ModelAndView view = new ModelAndView("/page/login");
		if(SecurityUtils.getSubject().isAuthenticated()){
			view.setViewName("/page/index");
		}
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public Object postLogin(String loginname, String password){
		LOGGER.info("POST请求登录");
		if(StringUtils.isEmpty(loginname) || StringUtils.isEmpty(password)){
			return renderError("参数错误");
		}
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginname, password);
		token.setRememberMe(true);
		try {
			user.login(token);
		} catch (UnknownAccountException e) {
            LOGGER.error("账号不存在：{}", e);
            return renderError("账号不存在");
        } catch (DisabledAccountException e) {
            LOGGER.error("账号未启用：{}", e);
            return renderError("账号未启用");
        } catch (IncorrectCredentialsException e) {
            LOGGER.error("密码错误：{}", e);
            return renderError("密码错误");
        } catch (RuntimeException e) {
            LOGGER.error("未知错误,请联系管理员：{}", e);
            return renderError("未知错误,请联系管理员");
        }
		return renderSuccess();
	}
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("/page/index");
		return view;
	}
	
	@RequestMapping("/index")
	public ModelAndView theIndex(){
		ModelAndView view = new ModelAndView("/page/index");
		return view;
	}
	
	@ResponseBody
	@RequestMapping("/logout")
	public Object logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return renderSuccess();
	}
	
	@RequestMapping("unauth")
	public ModelAndView unauth(){
		ModelAndView view = new ModelAndView("/page/unauth");
		return view;
	}
	
}
