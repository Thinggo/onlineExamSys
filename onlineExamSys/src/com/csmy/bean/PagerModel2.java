package com.csmy.bean;

import java.util.List;

public class PagerModel2 {
	private int rows;
	private int page;
	private String order;
	private String where;
	private String sort;
	
	public int getPageIndex() {
		return page == 0 ? 1: page;
	}
	
	public int getPageSize() {
		return rows==0 ? 20:rows;
	}
	
	public String getOrder() {
		return order==null?"ASC":order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getWhere() {
		return where==null?"1=1":where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPage() {
		return page == 0 ? 1: page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getSort() {
		return sort == null ? "id" : sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
