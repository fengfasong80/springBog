package com.fc.springmvc.modules.right.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.modules.right.entity.AdminRole;
import com.fc.springmvc.modules.right.service.IAdminRoleService;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
@RestController
@RequestMapping("/right/adminRole")
public class AdminRoleController {

	@Autowired
	IAdminRoleService adminRoleService;
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/save")
	@ResponseBody
	public R<?> save(String adminId) {
		String[] roleIds = request.getParameterValues("roleIds[]");
		adminRoleService.deleteByAdminId(adminId);
		if (null != roleIds) {
			for (String roleId : roleIds) {
				AdminRole adminRole = new AdminRole();
				adminRole.setAdminId(adminId);
				adminRole.setRoleId(roleId);
				adminRoleService.save(adminRole);
			}
		}
		return R.ok(null);
	}
	
}
