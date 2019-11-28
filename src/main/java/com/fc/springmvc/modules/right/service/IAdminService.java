package com.fc.springmvc.modules.right.service;

import com.fc.springmvc.modules.right.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
public interface IAdminService extends IService<Admin> {

	/**
	 * 通过用户名得到管理员信息
	 * @param admin
	 * @return
	 */
	public Admin getAdminByUserName(Admin admin);
	
	
}
