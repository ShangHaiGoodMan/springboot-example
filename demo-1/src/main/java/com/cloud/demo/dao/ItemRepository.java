package com.cloud.demo.dao;

import java.util.List;


import com.cloud.demo.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>, JpaRepository<Item, Long>,
		JpaSpecificationExecutor<Item> {
	
	 List<Item> findByName(String name);
}