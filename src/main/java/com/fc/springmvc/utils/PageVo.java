package com.fc.springmvc.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageVo<T> extends Page<T> {
	private static final long serialVersionUID = 1L;

	public Page<T> setRows(long rows) {
		return super.setSize(rows);
	}

	public Page<T> setPage(long page) {
		return super.setCurrent(page);
	}
	
}
