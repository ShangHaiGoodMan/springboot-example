package com.cloud.demo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 商品表
 */
@Data
@Entity
@Table(name = "t_item")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Item {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "bigint(11) comment '主键'")
	private Long id; //主键 id

	@Column(name = "name",columnDefinition="varchar(32) COMMENT '名称'")
	private String name; // 名称

	@Column(name = "category",columnDefinition="varchar(32) COMMENT '分类'")
	private String category;// 分类

	@Column(name = "price",columnDefinition="numeric(12,2) COMMENT '价格'")
	private BigDecimal price; // 价格

}
