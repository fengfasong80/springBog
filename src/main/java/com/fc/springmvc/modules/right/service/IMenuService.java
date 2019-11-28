package com.fc.springmvc.modules.right.service;

import com.fc.springmvc.modules.right.entity.Menu;
import com.fc.springmvc.modules.right.vo.MenuVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
public interface IMenuService extends IService<Menu> {

	public List<MenuVo> getAdminMenu(String userId);
    
    public List<MenuVo> getAllMenu();
    
    public List<MenuVo> getFirstDegree();
    
    public List<MenuVo> getByParentId(String parentId);
    
    public boolean hasChild(MenuVo menu);
    
    public List<MenuVo> renderRoleMenuTree(String roleId, String parentId);
    
    public boolean initRoleMenu(String roleId, String[] menuIds);
	
}
