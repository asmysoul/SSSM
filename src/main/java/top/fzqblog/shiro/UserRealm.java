package top.fzqblog.shiro;



import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import top.fzqblog.po.model.User;
import top.fzqblog.service.RoleService;
import top.fzqblog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.tools.javac.util.List;




public class UserRealm extends AuthorizingRealm{
	 private static final Logger LOGGER = LogManager.getLogger(UserRealm.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		LOGGER.info("授权开始......");
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		Set<String> permissions = this.roleService.findResourceListByRoleId(shiroUser.roleSet);
		permissions.remove("");
		System.out.println(permissions);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
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
		Set<Long> roleSet = this.userService.findRoleIdsByUserId(user.getId());
		ShiroUser shiroUser = new ShiroUser(user.getId(), user.getLoginname(), user.getName(), roleSet);
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser, user.getPassword(), getName());
		return authenticationInfo;
	}

}
