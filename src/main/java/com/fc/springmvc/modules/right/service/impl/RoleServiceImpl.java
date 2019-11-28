package com.fc.springmvc.modules.right.service.impl;

import com.fc.springmvc.modules.right.entity.Role;
import com.fc.springmvc.modules.right.mapper.RoleMapper;
import com.fc.springmvc.modules.right.service.IRoleService;
import com.fc.springmvc.modules.right.vo.RoleVo;
import com.fc.springmvc.utils.PageVo;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	
	
	@Override
	public PageVo<RoleVo> pageByAdminId(String userId, PageVo<RoleVo> page) {
		return baseMapper.listByAdminId(page, userId);
	}

}
