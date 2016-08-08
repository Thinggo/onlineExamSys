package com.csmy.bean;

public class ResultModel {
	private int status;
	private String msg;
	private boolean success;
	
	public ResultModel(int s, String m){
		status = s;
		msg = m;
		success = (s==0);
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
		success = (status==0);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}
}
