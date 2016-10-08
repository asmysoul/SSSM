/**
 *
 */
package top.fzqblog.shiro;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @description：自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 * @author：抽离
 * @date 2016 10 3
 */
public class ShiroUser implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    public Long id;
    public String loginname;
    public String name;
    public Set<Long> roleList;
    
    /**
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 */
	public ShiroUser() {
		// TODO Auto-generated constructor stub
	}
	
	
    

    /**
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @param id
	 * @param loginname
	 * @param name
	 * @param roleList
	 */
	public ShiroUser(Long id, String loginname, String name, Set<Long> roleList) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.name = name;
		this.roleList = roleList;
	}


	public String getName() {
        return name;
    }

    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
    @Override
    public String toString() {
        return loginname;
    }
}