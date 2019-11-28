package com.fc.springmvc.modules.right.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.modules.right.entity.Role;
import com.fc.springmvc.modules.right.service.IRoleService;
import com.fc.springmvc.modules.right.vo.RoleVo;
import com.fc.springmvc.utils.PageVo;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
@RestController
@RequestMapping("/right/role")
public class RoleController {
	@Autowired
	IRoleService roleService;

	@RequestMapping("pageByAdminId")
	@ResponseBody
	public Map<String, Object> pageByAdminId(String adminId, PageVo<RoleVo> page) {
		PageVo<RoleVo> pageByUserId = roleService.pageByAdminId(adminId, page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageByUserId.getTotal());
		map.put("rows", pageByUserId.getRecords());
		return map;
	}

	@RequestMapping("page")
	@ResponseBody
	public Map<String, Object> page(PageVo<Role> page, Role role) {
		IPage<Role> result = roleService.page(page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", result.getTotal());
		map.put("rows", result.getRecords());
		return map;
	}

	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public R<?> saveOrUpdate(Role role) {
		boolean flag = false;
		if (StringUtils.isEmpty(role.getId())) {
			flag = roleService.save(role);
		} else {
			flag = roleService.updateById(role);
		}
		R<?> aj = flag ? R.ok(role) : R.failed("删除失败");
		return aj;
	}

	@RequestMapping("delete")
	@ResponseBody
	public R<?> delete(Role role) {
		boolean flag = roleService.removeById(role.getId());
		R<?> aj = flag ? R.ok(role) : R.failed("删除失败");
		return aj;
	}
}
