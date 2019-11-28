package com.fc.springmvc.modules.right.vo;

import com.fc.springmvc.modules.right.entity.Role;

public class RoleVo extends Role{
	private static final long serialVersionUID = 1L;

	private Long count;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}
