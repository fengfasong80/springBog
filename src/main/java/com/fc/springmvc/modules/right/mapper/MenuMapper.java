package com.fc.springmvc.modules.right.mapper;

import com.fc.springmvc.modules.right.entity.Menu;
import com.fc.springmvc.modules.right.vo.MenuVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-10-12
 */
public interface MenuMapper extends BaseMapper<Menu> {

	/**
	 * 通过父菜单得到子菜单信息
	 * @param parentId  父菜单主键
	 * @return
	 */
	List<MenuVo> getMenuByParentId(@Param("parentId") String parentId);
	
	List<MenuVo> getMenuByAdminAndParentId(@Param("adminId") String adminId, @Param("parentId") String parentId);

    List<MenuVo> getFirstDegree();
    
    List<MenuVo> getByParentId(@Param("parentId")String parentId);
    
    List<MenuVo> getRoleMenuByParentId(@Param("roleId")String roleId, @Param("parentId")String parentId);    
	
}
