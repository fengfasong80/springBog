package com.fc.springmvc.modules.commerce.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fc.springmvc.modules.commerce.entity.Good;
import com.fc.springmvc.modules.commerce.vo.GoodVo;

public interface GoodService extends IService<Good> {

	public IPage<GoodVo> pageGood(Page<GoodVo> page, GoodVo good);
	
}
