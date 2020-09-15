package com.cloud.security.dao;

import java.math.BigDecimal;
import java.util.List;


import com.cloud.security.domain.Item;
import com.cloud.security.dto.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends CrudRepository<Item, Long>, JpaRepository<Item, Long>,
        JpaSpecificationExecutor<Item> {


    @Query("select new com.cloud.security.dto.ItemDTO(id, name, category, price) from Item where name = :name or category = :category or price = :price")
    List<ItemDTO> findByItems(@Param("name") String name, @Param("category") String category, @Param("price") BigDecimal price);

    List<Item> findByName(String name);
}