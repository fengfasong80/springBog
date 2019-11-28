package com.fc.springmvc.modules.right.mapper;

import com.fc.springmvc.modules.right.entity.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
	
	public Integer deleteByAdminId(String adminId);
	
}
