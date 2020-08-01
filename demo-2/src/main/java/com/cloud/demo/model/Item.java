package com.cloud.demo2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Mapping(mappingPath = "elasticsearch_mapping.json")//设置mapping
@Setting(settingPath = "elasticsearch_setting.json")//设置setting
@Document(indexName = "item", type = "docs", shards = 1, replicas = 0)
public class Item {
	@Id
	private Long id;

	@Field(type = FieldType.Text, analyzer = "ik_pinyin_analyzer")
	private String title; // 标题

	@Field(type = FieldType.Keyword)
	private String category;// 分类

	@Field(type = FieldType.Keyword)
	private String brand; // 品牌

	@Field(type = FieldType.Double)
	private Double price; // 价格

	@Field(index = false, type = FieldType.Keyword)
	private String images; // 图片地址
}
