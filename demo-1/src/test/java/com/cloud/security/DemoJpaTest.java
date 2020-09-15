package com.cloud.security;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.cloud.security.dao.ItemRepository;
import com.cloud.security.domain.Item;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoJpaTest {
	
	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void Test1(){
		itemRepository.save(new Item(null,"薯片", "垃圾食品", new BigDecimal(8.5)));
		List<Item> lists = new ArrayList<Item>();
		lists.add(new Item(null,"西瓜", "水果", new BigDecimal(12.5)));
		lists.add(new Item(null,"方便面", "速食", new BigDecimal(2.5)));
		lists.add(new Item(null,"洗发水", "日用品", new BigDecimal(39.9)));
		itemRepository.saveAll(lists);
	}

	@Test
	public void Test2(){
		itemRepository.deleteAll();
	}

	@Test
	public void Test3(){
		Gson gson = new Gson();
		String name = "西瓜";
		List<Item> results =  itemRepository.findByName(name);
		log.info(gson.toJson(results));
	}
}
