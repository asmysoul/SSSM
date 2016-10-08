
package top.fzqblog.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.mapper.RoleResourceMapper;
import top.fzqblog.mapper.UserMapper;
import top.fzqblog.mapper.UserRoleMapper;
import top.fzqblog.po.model.RoleResource;
import top.fzqblog.po.model.User;
import top.fzqblog.po.model.UserRole;
import top.fzqblog.po.query.RoleResourceQuery;
import top.fzqblog.po.query.UserQuery;
import top.fzqblog.po.query.UserRoleQuery;
import top.fzqblog.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper<User, UserQuery> userMapper;
	
	@Autowired
	private UserRoleMapper<UserRole, UserRoleQuery> userRoleMapper;
	
	@Autowired
	private RoleResourceMapper<RoleResource, RoleResourceQuery> roleResourceMapper;
	

	public User findUserByLoginName(String loginname) {
		UserQuery userQuery = new UserQuery();
		userQuery.setLoginname(loginname);
		List<User> list = this.userMapper.selectList(userQuery);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}


	/* (非 Javadoc)
	 * Description:
	 * @see top.fzqblog.service.UserService#findUserById(java.lang.Long)
	 */
	public User findUserById(Long id) {
		UserQuery userQuery = new UserQuery();
		userQuery.setId(id);
		List<User> list = this.userMapper.selectList(userQuery);
		if(!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}


	/* (非 Javadoc)
	 * Description:返回用户所有角色的Id
	 * @see top.fzqblog.service.UserService#findRoleIdsByUserId(long)
	 */
	public Set<Long> findRoleIdsByUserId(long userId) {
		return this.userRoleMapper.selectRoleIdsByUserId(userId);
	}


	/* (非 Javadoc)
	 * Description:根据拥有角色Id集合查出拥有资源Id集合
	 * @see top.fzqblog.service.UserService#findResourceIdByRoleId(java.util.Set)
	 */
	public Set<Long> findResourceIdByRoleId(Set<Long> roleSet) {
		return this.roleResourceMapper.selectResourceIdByRoleId(roleSet);
	}
}
