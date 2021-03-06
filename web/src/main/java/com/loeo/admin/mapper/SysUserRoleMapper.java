package com.loeo.admin.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.loeo.admin.domain.entity.SysRole;
import com.loeo.admin.domain.entity.SysUserRole;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LT
 * @since 2017-05-25
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

	void saveUserRoles(@Param("roles") List<SysRole> roles, @Param("userId") Serializable userId);

    List<String> findUserIdByRoleId(@Param("roleId") Serializable roleId);
}