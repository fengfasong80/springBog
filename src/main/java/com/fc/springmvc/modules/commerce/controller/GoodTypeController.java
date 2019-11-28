package com.fc.springmvc.modules.commerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.fc.springmvc.modules.commerce.entity.GoodType;
import com.fc.springmvc.modules.commerce.service.GoodTypeService;
import com.fc.springmvc.utils.PageVo;

@Controller
@RequestMapping("commerce/goodType")
public class GoodTypeController {

	@Autowired
	GoodTypeService goodTypeService;
	
	@RequestMapping("save")
	@ResponseBody
	public R<?> save(GoodType good) {
		boolean save = goodTypeService.save(good);
		return save ? R.ok(good.getId()) : R.failed("保存失败");
	}
	
	@RequestMapping("removeById")
	@ResponseBody
	public R<?> removeById(GoodType good) {
		boolean save = goodTypeService.removeById(good.getId());
		return save ? R.ok(null) : R.failed("删除失败");
	}
	
	@RequestMapping("updateById")
	@ResponseBody
	public R<?> updateById(GoodType good) {
		boolean save = goodTypeService.updateById(good);
		return save ? R.ok(null) : R.failed("修改失败");
	}
	
	@RequestMapping("pageGoodType")
	@ResponseBody
	public Map<String, Object> pageGoodType(PageVo<GoodType> page, GoodType goodType) {
		IPage<GoodType> pageGood = goodTypeService.pageGoodType(page, goodType);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pageGood.getTotal());
		result.put("rows", pageGood.getRecords());
		return result;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public List<GoodType> list(){
		return goodTypeService.list();
	}
}
