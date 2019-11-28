package com.fc.springmvc.modules.right.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.cons.SessionConst;
import com.fc.springmvc.modules.interceptor.AuthorizationInterceptor;
import com.fc.springmvc.modules.right.entity.Admin;
import com.fc.springmvc.modules.right.entity.Menu;
import com.fc.springmvc.modules.right.entity.Role;
import com.fc.springmvc.modules.right.service.IAdminService;
import com.fc.springmvc.modules.right.service.IMenuService;
import com.fc.springmvc.modules.right.vo.MenuVo;
import com.jfinal.kit.PropKit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
@RestController
@RequestMapping("/right/menu")
public class MenuController {
	@Autowired
	HttpSession session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	IMenuService menuService;
	@Autowired
	IAdminService adminService;
	Boolean devMode=PropKit.use("config.properties").getBoolean("dev.mode");
	
	@RequestMapping("saveOrUpdate")
	@ResponseBody
	public R<?> saveOrUpdate(Menu menu) {
		boolean flag = false;
		if (StringUtils.isEmpty(menu.getId())) {
			flag = menuService.save(menu);
		} else {
			flag = menuService.updateById(menu);
		}
		R<?> rp = flag ? R.ok(menu) : R.failed("保存失败");
		return rp;
	}

	@ResponseBody
	@RequestMapping("getAdminMenu")
	public List<MenuVo> getAdminMenu() {
		String userId = (String) request.getAttribute(AuthorizationInterceptor.USER_KEY);
		Admin sessionAdmin= adminService.getById(userId);
		@SuppressWarnings("unchecked")
		List<MenuVo> adminMenu = (List<MenuVo>) session.getAttribute(SessionConst.SESSION_MENU);
		if (null == adminMenu) {
			if (devMode) {
				adminMenu = menuService.getAllMenu();
			} else {
				adminMenu = menuService.getAdminMenu(sessionAdmin.getId());
			}
			session.setAttribute(SessionConst.SESSION_MENU, adminMenu);
		}
		return adminMenu;
	}

	@RequestMapping("delete")
	@ResponseBody
	public boolean delete(Menu menu) {
		return menuService.removeById(menu.getId());
	}

	@RequestMapping("renderAsyncTree")
	@ResponseBody
	public List<MenuVo> renderAsyncTree(String id) {
		List<MenuVo> menu;
		if (StringUtils.isBlank(id)) {
			menu = menuService.getFirstDegree();
		} else {
			menu = menuService.getByParentId(id);
		}
		initTreeValue(menu);
		return menu;
	}

	private void initTreeValue(List<MenuVo> records) {
		for (MenuVo record : records) {
			record.setState(menuService.hasChild(record) ? "closed" : "open");
		}
	}

	@RequestMapping("renderRoleMenuTree")
	@ResponseBody
	public List<MenuVo> renderRoleMenuTree(Role role) {
		List<MenuVo> records = menuService.renderRoleMenuTree(role.getId(), null);
		return records;
	}

	@RequestMapping("initRoleMenu")
	@ResponseBody
	public R<?> initRoleMenu(String roleId) {
		String[] menuIds = request.getParameterValues("menuIds[]");
		R<?> rp = menuService.initRoleMenu(roleId, menuIds) ? R.ok(null) : R.failed("操作失败");
		return rp;
	}

}
