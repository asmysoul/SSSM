
package top.fzqblog.service;



import java.util.List;
import java.util.Set;

import top.fzqblog.po.model.User;


public interface UserService {
	
	public User findUserByLoginName(String loginname);
	
	public User findUserById(Long id);
	
	public Set<Long> findRoleIdsByUserId(long userId);
	
	public Set<Long> findResourceIdByRoleId(Set<Long> roleSet);
}
