package com.fc.springmvc.modules.right.service.impl;

import com.fc.springmvc.modules.right.entity.Menu;
import com.fc.springmvc.modules.right.entity.RoleMenu;
import com.fc.springmvc.modules.right.mapper.MenuMapper;
import com.fc.springmvc.modules.right.service.IMenuService;
import com.fc.springmvc.modules.right.service.IRoleMenuService;
import com.fc.springmvc.modules.right.vo.MenuVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

	@Autowired
	IRoleMenuService roleMenuService;
	
    @Override
    public List<MenuVo> getAdminMenu(String userId) {
        List<MenuVo> parentMenus = super.baseMapper.getMenuByAdminAndParentId(userId, "");
        for (MenuVo parentMenu : parentMenus){
            List<MenuVo> childMenus = super.baseMapper.getMenuByAdminAndParentId(userId, parentMenu.getId());
            parentMenu.setChildMenus(childMenus);
        }
        return parentMenus;
    }

	@Override
	public List<MenuVo> getAllMenu() {
		List<MenuVo> parentMenus = baseMapper.getMenuByParentId(null);
		for (MenuVo parentMenu : parentMenus) {
			List<MenuVo> childMenus = super.baseMapper.getMenuByParentId(parentMenu.getId());
			parentMenu.setChildMenus(childMenus);
		}
		return parentMenus;
	}

	@Override
	public List<MenuVo> getFirstDegree() {
		return baseMapper.getFirstDegree();
	}

	@Override
	public List<MenuVo> getByParentId(String parentId) {
		return baseMapper.getByParentId(parentId);
	}

	@Override
	public boolean hasChild(MenuVo menu) {
		QueryWrapper<Menu> wrapper = new QueryWrapper<>();
		wrapper.eq("parentId", menu.getId());
		return baseMapper.selectCount(wrapper) > 0;
	}

	@Override
	public List<MenuVo> renderRoleMenuTree(String roleId, String parentId) {
		List<MenuVo> resources = baseMapper.getRoleMenuByParentId(roleId, parentId);
		for (MenuVo resource : resources) {
			List<MenuVo> childs = renderRoleMenuTree(roleId, resource.getId());
			if (null != childs && !childs.isEmpty()) {
				resource.setChecked(false);
			}
			resource.setChildren(childs);
		}
		return resources;
	}

	@Override
	public boolean initRoleMenu(String roleId, String[] menuIds) {
		QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
		wrapper.eq("roleId", roleId);
		roleMenuService.remove(wrapper);
		if (null != menuIds) {
			for (String menuId : menuIds) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(menuId);
				roleMenuService.save(roleMenu);
			}
		}
		return true;
	}

	public boolean deleteById(Serializable id) {
		QueryWrapper<Menu> wrapper = new QueryWrapper<>();
		wrapper.eq("parentId", id);
		List<Menu> childMenus = 	super.list(wrapper);
		if (childMenus.size() > 0) {
			for (Menu childMenu : childMenus) {
				deleteById(childMenu.getId());
			}
		}
		return super.removeById(id);
	}
	
}
