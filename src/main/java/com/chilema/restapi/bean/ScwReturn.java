package com.chilema.restapi.bean;

import java.util.Map;

/**
 * 因为涉及到很多的返回值类型，所以ScwReturn<T>包含的对象类型为泛型；测试
 * @param <T>
 */
public class ScwReturn<T> {

	private int code; // 状态吗 1：表示成功， 0: 表示失败；
	private String msg; // 要给的提示信息
	private T content; // 响应的内容
	private Map<String, Object> ext; // 额外的数据；
	
	//只生成get/set方法；
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public Map<String, Object> getExt() {
		return ext;
	}

	public void setExt(Map<String, Object> ext) {
		this.ext = ext;
	}
	
	/**
	 模拟返回的数据类型 ScwReturn<T>
	 {
	 	code:1,
	 	
	 	msg:"用户注册成功！",
	 	
	 	content:[
	 	{username:"zhangsan", pwd: '123'},
	 	{suername:"lisi", pwd:'232'}
	 	],
	 	
	 	ext:{
	 		a: "先去激活",
	 		b: "去做另一个步骤"
	 	}
	 }
	 */
	//定义成功和失败的方法
	//成功的方法， 泛型返回值类型的使用
	public static <T> ScwReturn<T> success(String msg, T content, Map<String, Object> ext){
		ScwReturn<T> sr  = new ScwReturn<T>();
		sr.setCode(1);
		sr.setMsg(msg);
		sr.setContent(content);
		sr.setExt(ext);
		return sr;
	}
	
	public static <T> ScwReturn<T> fail(String msg, T content, Map<String, Object> ext){
		ScwReturn<T> sr  = new ScwReturn<T>();
		sr.setCode(0);
		sr.setMsg(msg);
		sr.setContent(content);
		sr.setExt(ext);
		return sr;
	}
	
}
