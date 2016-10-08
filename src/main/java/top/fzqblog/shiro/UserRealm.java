package top.fzqblog.shiro;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import top.fzqblog.po.model.User;
import top.fzqblog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;




public class UserRealm extends AuthorizingRealm{
	 private static final Logger LOGGER = LogManager.getLogger(UserRealm.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		LOGGER.info("授权开始......");
		return null;
	}

	
	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		LOGGER.info("登录认证开始......");
		String loginname = (String) token.getPrincipal();
		User user = this.userService.findUserByLoginName(loginname);
		if(user == null || user.getStatus() == 1){
			return null;
		}
		ShiroUser shiroUser = new ShiroUser(user.getId(), user.getLoginname(), user.getName(), null);
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser, user.getPassword(), getName());
		return authenticationInfo;
	}

}
