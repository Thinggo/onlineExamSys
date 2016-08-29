package com.csmy.vo;

import java.util.List;

public class PagerModel<E> {
	private int total;
	private List<E> rows;	
	private List<E> footer;
	
	public PagerModel(int total, List<E> rows){
		this.total = total;
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	public List<E> getFooter() {
		return footer;
	}
	public void setFooter(List<E> footer) {
		this.footer = footer;
	}
}
