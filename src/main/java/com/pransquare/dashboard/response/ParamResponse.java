package com.pransquare.dashboard.response;

import java.io.Serializable;

public class ParamResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object res;
	private String message;
	
	public ParamResponse() {}

	public ParamResponse(Object res, String message) {
		super();
		this.res = res;
		this.message = message;
	}

	public Object getRes() {
		return res;
	}

	public void setRes(Object res) {
		this.res = res;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
