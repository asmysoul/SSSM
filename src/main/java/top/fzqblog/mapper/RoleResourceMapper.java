package top.fzqblog.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;




public interface RoleResourceMapper<T, Q> extends BaseMapper<T, Q>{
    
	public Set<Long> selectResourceIdByRoleId(@Param("roleSet") Set<Long> roleSet);
	
	public void insertBatch(@Param("roleId") Long roleId, @Param("resourceIds") Long[] resourceIds);
}