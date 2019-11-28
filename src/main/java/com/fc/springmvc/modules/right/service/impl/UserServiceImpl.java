package com.fc.springmvc.modules.right.service.impl;





import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fc.springmvc.modules.right.entity.User;
import com.fc.springmvc.modules.right.mapper.UserMapper;
import com.fc.springmvc.modules.right.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	public User getUserByUsername(String username) {
		/**
		 * select * from user where username=map_username
		 */
		QueryWrapper<User> wrapper = new QueryWrapper<User>();
		wrapper.eq(true, "username", username);
		return baseMapper.selectOne(wrapper);
//		return baseMapper.getUserByUsername(username);
	}


}
