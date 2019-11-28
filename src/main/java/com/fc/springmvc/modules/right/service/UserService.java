package com.fc.springmvc.modules.right.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fc.springmvc.modules.right.entity.User;

public interface UserService extends IService<User> {

	public User getUserByUsername(String username);
	
}
