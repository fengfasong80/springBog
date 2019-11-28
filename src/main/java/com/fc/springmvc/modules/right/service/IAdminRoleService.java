package com.fc.springmvc.modules.right.service;

import com.fc.springmvc.modules.right.entity.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
public interface IAdminRoleService extends IService<AdminRole> {
	
	public Integer deleteByAdminId(String adminId);
	
}
