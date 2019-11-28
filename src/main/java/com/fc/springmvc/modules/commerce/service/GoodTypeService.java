package com.fc.springmvc.modules.commerce.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fc.springmvc.modules.commerce.entity.GoodType;

public interface GoodTypeService extends IService<GoodType> {

	public IPage<GoodType> pageGoodType(Page<GoodType> page, GoodType goodType);
	
}
