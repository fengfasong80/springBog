package com.fc.springmvc.modules.right.mapper;


import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fc.springmvc.modules.right.entity.User;

public interface UserMapper extends BaseMapper<User>{

	public User getUserByUsername(@Param("username")String username);
	
}
