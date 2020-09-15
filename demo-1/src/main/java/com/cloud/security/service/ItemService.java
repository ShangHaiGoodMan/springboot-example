package com.cloud.security.service;

import com.cloud.security.dto.ItemDTO;
import com.cloud.security.dto.Result;

public interface ItemService {

    Result query(ItemDTO itemDTO);

    Result insert(ItemDTO itemDTO);

    Result update(ItemDTO itemDTO);

    Result delete(ItemDTO itemDTO);
}
