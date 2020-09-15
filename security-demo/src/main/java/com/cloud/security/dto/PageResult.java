package com.cloud.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


/**
 * 分页实体类
 * code  是否成功
 * msg  备注
 * total 总数
 * data 当前页结果集
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = -275582248840137389L;
	private int code;
	private String msg;
	private int count;
	private List<T> data;
}
