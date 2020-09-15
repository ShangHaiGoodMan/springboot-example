package com.cloud.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResponseEnum {

	R200(200,"成功"),

	E100(100,"通用失败返回"),

	R101(101,"请求报文非法"),
	R111(111,"请求异常"),


	S403(403,"服务没有授权"),
	S404(404,"服务不存在"),
	S500(500,"服务异常"),


	U401(401,"没有操作权限"),
	U410(410,"登录用户已过期，请重新登录！"),
	U411(411,"用户已被禁用"),
	U412(412,"用户已登出"),
	U413(413,"登录用户已过期，请重新登录！"),
	U414(414,"用户名或密码错误");

	private int code;
	private String msg;
	
}
