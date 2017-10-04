package com.zhiyou100.vo;

public class ViewVo {
	
	private Integer pageIndex;
	
	private Integer beginNum;
	
	private Integer count;
	
	private String sort;
	
	private String accord;

	public ViewVo() {
		super();
	}

	
	
	public ViewVo(Integer pageIndex, Integer beginNum, Integer count, String sort, String accord) {
		super();
		this.pageIndex = pageIndex;
		this.beginNum = beginNum;
		this.count = count;
		this.sort = sort;
		this.accord = accord;
	}


	@Override
	public String toString() {
		return "ViewVo [pageIndex=" + pageIndex + ", beginNum=" + beginNum + ", count=" + count + ", sort=" + sort
				+ ", accord=" + accord + "]";
	}



	public Integer getBeginNum() {
		return beginNum;
	}

	public void setBeginNum(Integer beginNum) {
		this.beginNum = beginNum;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getAccord() {
		return accord;
	}

	public void setAccord(String accord) {
		this.accord = accord;
	}



	public Integer getPageIndex() {
		return pageIndex;
	}



	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
}
