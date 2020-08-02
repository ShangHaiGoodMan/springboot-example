package com.cloud.demo.service;

import com.cloud.demo.dto.ItemDTO;
import com.cloud.demo.dto.Result;

public interface ItemService {

    Result query(ItemDTO itemDTO);

    Result insert(ItemDTO itemDTO);

    Result update(ItemDTO itemDTO);

    Result delete(ItemDTO itemDTO);
}
