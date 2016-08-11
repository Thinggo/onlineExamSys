package com.csmy.db;

import java.util.List;

public class PagerModel<E> {
	private int total;
	private List<E> rows;	
	
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
}
