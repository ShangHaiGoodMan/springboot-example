package com.cloud.demo2.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.cloud.demo2.model.Item;

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
	
	 List<Item> findByPriceBetween(double price1, double price2);
}