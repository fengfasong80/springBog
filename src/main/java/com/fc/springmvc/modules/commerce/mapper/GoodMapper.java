package com.fc.springmvc.modules.commerce.mapper;



import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fc.springmvc.modules.commerce.entity.Good;
import com.fc.springmvc.modules.commerce.vo.GoodVo;

public interface GoodMapper extends BaseMapper<Good>{

	/**
	 * 分页查看商品信息
	 * @param page
	 * @return
	 */
	IPage<GoodVo> pageGood(Page<?> page, @Param("good")GoodVo good);
	
}
