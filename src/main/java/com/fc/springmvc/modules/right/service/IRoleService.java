package com.fc.springmvc.modules.right.service;

import com.fc.springmvc.modules.right.entity.Role;
import com.fc.springmvc.modules.right.vo.RoleVo;
import com.fc.springmvc.utils.PageVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
public interface IRoleService extends IService<Role> {

	public PageVo<RoleVo> pageByAdminId(String userId, PageVo<RoleVo> page);
	
}
