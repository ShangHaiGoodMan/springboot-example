package com.cloud.security.controller;

import com.cloud.security.dto.ItemDTO;
import com.cloud.security.dto.Result;
import com.cloud.security.dto.groups.DeletedValidated;
import com.cloud.security.dto.groups.InsertValidated;
import com.cloud.security.dto.groups.QueryValidated;
import com.cloud.security.dto.groups.UpdateValidated;
import com.cloud.security.service.ItemService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ItemController {

    @Resource
    private ItemService itemService;

    @PostMapping("query")
    public Result query(@RequestBody @Validated(QueryValidated.class) ItemDTO itemDTO){
        return itemService.query(itemDTO);
    }

    @PostMapping("insert")
    public Result insert(@RequestBody @Validated(InsertValidated.class) ItemDTO itemDTO) {
        return itemService.insert(itemDTO);
    }

    @PostMapping("update")
    public Result update(@RequestBody @Validated(UpdateValidated.class) ItemDTO itemDTO) {
        return itemService.update(itemDTO);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody @Validated(DeletedValidated.class) ItemDTO itemDTO) {
        return itemService.delete(itemDTO);
    }
}
