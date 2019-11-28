package com.fc.springmvc.modules.right.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("view/{path1}")
	public String view1(@PathVariable("path1") String path1) {
		return path1;
	}
	
	@RequestMapping("view/{path1}/{path2}")
	public String view2(@PathVariable("path1") String path1, @PathVariable("path2") String path2) {
		return path1 + "/" + path2;
	}
	
	@RequestMapping("view/{path1}/{path2}/{path3}")
	public String view3(@PathVariable("path1") String path1, @PathVariable("path2") String path2, @PathVariable("path3") String path3) {
		return path1 + "/" + path2+ "/" + path3;
	}
	
}
