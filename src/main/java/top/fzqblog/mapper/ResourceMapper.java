package top.fzqblog.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import top.fzqblog.po.model.Resource;

public interface ResourceMapper<T,Q> extends BaseMapper<T, Q> {
	
	public List<Resource> selectMenuByRoleId(@Param("roleIds") Set<Long> roleIds, @Param("resourceType") Integer resourceType);
	
	public List<Resource> selectMenuByRoleIdAndPid(@Param("roleIds") Set<Long> roleIds, @Param("resourceType") Integer resourceType, @Param("pid") Long pid);
}