package com.zhiyou100.vo;

import java.util.List;

public class PageInfo <T> {
	
	private int allPageCount;
	
	private List<T> data;

	public PageInfo() {
		super();
	}

	public PageInfo(int allPageCount, List<T> data) {
		super();
		this.allPageCount = allPageCount;
		this.data = data;
	}

	@Override
	public String toString() {
		return "PageInfo [allPageCount=" + allPageCount + ", data=" + data + "]";
	}

	public int getAllPageCount() {
		return allPageCount;
	}

	public void setAllPageCount(int allPageCount) {
		this.allPageCount = allPageCount;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
