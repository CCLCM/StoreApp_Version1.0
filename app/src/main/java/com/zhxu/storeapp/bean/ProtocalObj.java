package com.zhxu.storeapp.bean;

import com.google.gson.Gson;

public class ProtocalObj {

	public String toJson() {
		Gson gson=new Gson();
		return gson.toJson(this);
	}
	public Object fromJson(String json) {
		Gson gson=new Gson();
		return gson.fromJson(json, this.getClass());
	}
}