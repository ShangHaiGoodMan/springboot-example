package com.cloud.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResponseMessage {

	R000(200,"成功"),
	R001(201,"查询成功无数据"),

	R101(101,"请求报文非法"),
	R111(111,"请求异常"),

	S403(403,"服务没有授权"),
	S404(404,"服务不存在"),
	S500(500,"服务异常"),

	U101(101,"用户名或密码错误"),
	U102(102,"用户已被禁用"),
	U103(103,"用户已登出"),
	U104(104,"登录用户已过期，请重新登录！"),

	U401(401,"未授权");


	private int code;
	private String msg;
	
}
