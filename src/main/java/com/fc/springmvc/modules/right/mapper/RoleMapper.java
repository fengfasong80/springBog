package com.fc.springmvc.modules.right.mapper;

import com.fc.springmvc.modules.right.entity.Role;
import com.fc.springmvc.modules.right.vo.RoleVo;
import com.fc.springmvc.utils.PageVo;
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
public interface RoleMapper extends BaseMapper<Role> {

	public PageVo<RoleVo> listByAdminId(PageVo<RoleVo> page, @Param("adminId") String adminId);
	
}
