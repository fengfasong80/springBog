package com.fc.springmvc.modules.right.service.impl;

import com.fc.springmvc.modules.right.entity.Admin;
import com.fc.springmvc.modules.right.mapper.AdminMapper;
import com.fc.springmvc.modules.right.service.IAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

	@Override
	public Admin getAdminByUserName(Admin admin) {
		QueryWrapper<Admin> qr = new QueryWrapper<>();
		qr.eq("username", admin.getUsername());
		return super.getOne(qr);
	}

}
