package com.fc.springmvc.modules.right.service.impl;

import com.fc.springmvc.modules.right.entity.AdminRole;
import com.fc.springmvc.modules.right.mapper.AdminRoleMapper;
import com.fc.springmvc.modules.right.service.IAdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

	@Override
	public Integer deleteByAdminId(String adminId) {
		return baseMapper.deleteByAdminId(adminId);
	}
	
}
