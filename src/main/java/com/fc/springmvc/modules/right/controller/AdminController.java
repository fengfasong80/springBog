package com.fc.springmvc.modules.right.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.aop.ControllerAspect;
import com.fc.springmvc.cons.SessionConst;
import com.fc.springmvc.modules.right.entity.Admin;
import com.fc.springmvc.modules.right.service.IAdminService;
import com.fc.springmvc.utils.JwtUtils;
import com.fc.springmvc.utils.MD5Util;
import com.fc.springmvc.utils.PageVo;
import com.fc.springmvc.utils.WebContextKit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
@RequestMapping("/right/admin")
@Controller
public class AdminController {

	@Autowired
	IAdminService adminService;
	@Autowired
	HttpSession session;

	@Autowired
	ControllerAspect controllerAspect;
	@Autowired
	HttpServletResponse response;
	
	@RequestMapping("login")
	@ResponseBody
	public R<?> login(Admin admin) {
		if (StringUtils.isBlank(admin.getUsername())) {
			return R.failed("用户名不能为空");
		}
		if (StringUtils.isBlank(admin.getPassword())) {
			return R.failed("密码不能为空");
		}
		Admin adminByAdminName = adminService.getAdminByUserName(admin);
		if (null == adminByAdminName) {
			return R.failed("用户名不存在");
		}
		if (!MD5Util.encrypt(admin.getPassword()).equals(adminByAdminName.getPassword())) {
			return R.failed("密码错误");
		}
//		session.setAttribute(SessionConst.SESSION_ADMIN, adminByAdminName);
		String generateToken = JwtUtils.generateToken(adminByAdminName.getId());
		WebContextKit.setCookie(response, "token", generateToken, JwtUtils.expire.intValue(), false);
		return R.ok(null);
	}

	@RequestMapping("logout")
	public String logout(Admin admin) {
		session.invalidate();
		return "login";
	}

	/**
	 * 修改密码
	 * 
	 * @param oldPassword
	 *            原密码
	 * @param admin
	 *            admin.password 是新密码
	 * @return
	 */
	@RequestMapping("updatePwd")
	@ResponseBody
	public R<?> updatePwd(String oldPassword, Admin admin) {
		if (StringUtils.isBlank(oldPassword)) {
			return R.failed("原密码不能为空");
		}
		if (StringUtils.isBlank(admin.getPassword())) {
			return R.failed("密码不能为空");
		}
		Admin sessionAdmin = (Admin) session.getAttribute(SessionConst.SESSION_ADMIN);
		if (!MD5Util.encrypt(oldPassword).equals(sessionAdmin.getPassword())) {
			return R.failed("原密码输入有误");
		}
		sessionAdmin.setPassword(MD5Util.encrypt(admin.getPassword()));
		boolean updateFlag = adminService.updateById(sessionAdmin);
		if (updateFlag) {
			session.setAttribute(SessionConst.SESSION_ADMIN, sessionAdmin);
			return R.ok(null);
		} else {
			return R.failed("密码修改失败");
		}
	}

	@RequestMapping("/page")
	@ResponseBody
	public Map<String, Object> page(PageVo<Admin> pageInfo, Admin admin) {
		IPage<Admin> page = adminService.page(pageInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", page.getTotal());
		map.put("rows", page.getRecords());
		return map;
	}

	@RequestMapping("/update")
	@ResponseBody
	public R<?> update(Admin admin) {
		admin.setUsername(null);
		admin.setPassword(null);
		Boolean result = adminService.updateById(admin);
		return result ? R.ok(admin) : R.failed("修改失败");
	}

	@RequestMapping("/save")
	@ResponseBody
	public R<?> save(Admin admin) {
		admin.setPassword(MD5Util.encrypt(admin.getPassword()));
		Boolean result = adminService.save(admin);
		return result ? R.ok(admin) : R.failed("保存成功");
	}

	@RequestMapping("/delete")
	@ResponseBody
	public R<?> delete(Admin admin) {
		Boolean result = adminService.removeById(admin.getId());
		return result ? R.ok(null) : R.failed("删除失败");
	}

}
