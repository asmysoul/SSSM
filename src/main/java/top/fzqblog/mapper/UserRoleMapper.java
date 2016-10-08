package top.fzqblog.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;





public interface UserRoleMapper<T, Q> extends BaseMapper<T, Q>{
	
	public Set<Long> selectRoleIdsByUserId(@Param("userId") long userId);
}