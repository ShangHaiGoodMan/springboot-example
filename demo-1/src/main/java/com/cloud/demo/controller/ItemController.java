package com.cloud.demo.controller;

import com.cloud.demo.dto.ItemDTO;
import com.cloud.demo.dto.Result;
import com.cloud.demo.dto.groups.DeletedValidated;
import com.cloud.demo.dto.groups.InsertValidated;
import com.cloud.demo.dto.groups.QueryValidated;
import com.cloud.demo.dto.groups.UpdateValidated;
import com.cloud.demo.service.ItemService;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
