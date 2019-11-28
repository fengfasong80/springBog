package com.fc.springmvc.modules.commerce.service.impl;





import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fc.springmvc.modules.commerce.entity.GoodType;
import com.fc.springmvc.modules.commerce.mapper.GoodTypeMapper;
import com.fc.springmvc.modules.commerce.service.GoodTypeService;


@Service
public class GoodTypeServiceImpl extends ServiceImpl<GoodTypeMapper, GoodType> implements GoodTypeService {

	@Override
	public IPage<GoodType> pageGoodType(Page<GoodType> page, GoodType goodType) {
		return super.baseMapper.pageGoodType(page, goodType);
	}

	


}
