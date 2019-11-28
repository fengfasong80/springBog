package com.fc.springmvc.modules.right.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.modules.right.entity.User;
import com.fc.springmvc.modules.right.service.UserService;

@Controller
@RequestMapping("right/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("regist")
	@ResponseBody
	public R<?> regist(User user) {
		if (StringUtils.isBlank(user.getUsername())) {
			return R.failed("请输入用户名");
		}
		User userByUsername = userService.getUserByUsername(user.getUsername());
		if (null != userByUsername) {
			return R.failed("用户名已经存在");
		}
		boolean save = userService.save(user);
		return save ? R.ok(null) : R.failed("保存用户信息失败");
	}
	
	@RequestMapping("login")
	public String login(User user, HttpServletRequest request) {
		User userByUsername = userService.getUserByUsername(user.getUsername());
		if (null == userByUsername || !userByUsername.getPassword().equals(user.getPassword())) {
			return "redirect:/view/login";
		} 
		request.getSession().setAttribute("SESSION_USER", userByUsername);
		return "redirect:/view/index";
	}
	
}
