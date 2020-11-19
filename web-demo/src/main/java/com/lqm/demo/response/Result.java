package com.lqm.demo.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回数据
 *
 * @Author
 */
@Data
public class Result<T> implements Serializable {

	private String code;

	private String message;

	private T data;

	public Result(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public Result() {}
	public static Result success() {
		Result r = new Result();
		r.setCode("0");
		r.setMessage("操作成功");
		return r;
	}

	public static Result success(Object data) {
		Result r = new Result();
		r.setCode("0");
		r.setMessage("操作成功");
		r.setData(data);
		return r;
	}
	public static Result fail(String code, String msg) {
		Result r = new Result();
		r.setCode(code);
		r.setMessage(msg);
		return r;
	}

	public static Result fail(String msg) {
		Result r = new Result();
		r.setCode("1");
		r.setMessage(msg);
		return r;
	}
}
