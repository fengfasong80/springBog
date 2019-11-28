package com.fc.springmvc.modules.right.vo;

import java.util.List;

import com.fc.springmvc.modules.right.entity.Menu;

public class MenuVo extends Menu {
	private static final long serialVersionUID = 1L;

	private Boolean checked;
	private String state;
	private List<MenuVo> children;
	private List<MenuVo> childMenus;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<MenuVo> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<MenuVo> childMenus) {
		this.childMenus = childMenus;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public List<MenuVo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuVo> children) {
		this.children = children;
	}

}
