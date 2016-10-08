package top.fzqblog.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface RoleMapper<T, Q> extends BaseMapper<T, Q> {
   public Set<String> selectResourceListByRoleId(@Param("roleIds") Set<Long> roleIds);
}