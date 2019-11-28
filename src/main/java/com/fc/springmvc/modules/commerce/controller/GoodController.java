package com.fc.springmvc.modules.commerce.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.modules.commerce.entity.Good;
import com.fc.springmvc.modules.commerce.service.GoodService;
import com.fc.springmvc.modules.commerce.service.GoodTypeService;
import com.fc.springmvc.modules.commerce.vo.GoodVo;
import com.fc.springmvc.utils.PageVo;

@Controller
@RequestMapping("commerce/good")
public class GoodController {

	@Autowired
	GoodService goodService;
	@Autowired
	GoodTypeService goodTypeService;
	
	@RequestMapping("save")
	@ResponseBody
	public R<?> save(Good good) {
		boolean save = goodService.save(good);
		return save ? R.ok(good.getId()) : R.failed("保存失败");
	}
	
	@RequestMapping("removeById")
	@ResponseBody
	public R<?> removeById(Good good) {
		boolean save = goodService.removeById(good.getId());
		return save ? R.ok(null) : R.failed("删除失败");
	}
	
	@RequestMapping("updateById")
	@ResponseBody
	public R<?> updateById(Good good) {
		boolean save = goodService.updateById(good);
		return save ? R.ok(null) : R.failed("修改失败");
	}
	
	@RequestMapping("pageGood")
	@ResponseBody
	public Map<String, Object> pageGood(PageVo<GoodVo> page, GoodVo good) {
		IPage<GoodVo> pageGood = goodService.pageGood(page, good);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pageGood.getTotal());
		result.put("rows", pageGood.getRecords());
		return result;
	}
	
}
