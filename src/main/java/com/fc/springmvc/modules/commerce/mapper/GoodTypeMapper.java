package com.fc.springmvc.modules.commerce.mapper;



import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fc.springmvc.modules.commerce.entity.GoodType;

public interface GoodTypeMapper extends BaseMapper<GoodType>{

	/**
	 * 分页查看商品信息
	 * @param page
	 * @return
	 */
	IPage<GoodType> pageGoodType(Page<?> page, @Param("goodType")GoodType good);
	
}
