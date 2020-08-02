package com.cloud.demo.service.impl;

import com.cloud.demo.dao.ItemRepository;
import com.cloud.demo.domain.Item;
import com.cloud.demo.dto.ItemDTO;
import com.cloud.demo.dto.Result;
import com.cloud.demo.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemRepository itemRepository;

    @Override
    public Result query(ItemDTO itemDTO) {
        List<ItemDTO> lists = itemRepository.findByItems(itemDTO.getName(), itemDTO.getCategory(), itemDTO.getPrice());
        return Result.ok(lists);
    }

    @Override
    public Result insert(ItemDTO itemDTO) {
        Item item = new Item();
        BeanUtils.copyProperties(itemDTO, item);
        itemRepository.save(item);
        return Result.ok();
    }

    @Override
    public Result update(ItemDTO itemDTO) {
        Optional<Item> itemOptional = itemRepository.findById(itemDTO.getId());
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            BeanUtils.copyProperties(itemDTO, item);
            itemRepository.save(item);
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    @Override
    public Result delete(ItemDTO itemDTO) {
        itemRepository.deleteById(itemDTO.getId());
        return Result.ok();
    }
}
