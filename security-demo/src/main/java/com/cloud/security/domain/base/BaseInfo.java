package com.cloud.security.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@MappedSuperclass
public class BaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "hibernate-uuid", strategy = "uuid")
	@GeneratedValue(generator = "hibernate-uuid")
	@Column(name = "id", columnDefinition = "varchar(32) comment '主编号'")
	private String id;

	@Version
	@Column(name = "version", columnDefinition = "int(11) comment '版本号'")
	private Integer version;

	@Column(name = "create_time", columnDefinition = "datetime comment '创建日期'")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	@Column(name = "update_time", columnDefinition = "datetime comment '更新时间'")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;

	@Column(name = "creator", columnDefinition = "varchar(32) comment '创建人'")
	private String creator;

	@Column(name = "updater", columnDefinition = "varchar(32) comment '更新人'")
	private String updater;
}
