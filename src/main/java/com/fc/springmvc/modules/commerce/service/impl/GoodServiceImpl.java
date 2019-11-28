package com.fc.springmvc.modules.commerce.service.impl;





import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fc.springmvc.modules.commerce.entity.Good;
import com.fc.springmvc.modules.commerce.mapper.GoodMapper;
import com.fc.springmvc.modules.commerce.service.GoodService;
import com.fc.springmvc.modules.commerce.vo.GoodVo;


@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements GoodService {

	public IPage<GoodVo> pageGood(Page<GoodVo> page, GoodVo good) {
		return baseMapper.pageGood(page, good);
	}

}
