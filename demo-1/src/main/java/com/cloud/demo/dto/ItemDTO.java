package com.cloud.demo.dto;

import com.cloud.demo.dto.groups.BaseValidated;
import com.cloud.demo.dto.groups.DeletedValidated;
import com.cloud.demo.dto.groups.QueryValidated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ItemDTO {

    @NotNull(message = "编号不为空", groups = {BaseValidated.class, DeletedValidated.class})
    private Long id; //主键 id

    @NotBlank(message = "名称不为空", groups = {BaseValidated.class, QueryValidated.class})
    private String name; // 名称

    @NotBlank(message = "分类不为空", groups = {BaseValidated.class})
    private String category;// 分类

    @NotNull(message = "价格不为空", groups = {BaseValidated.class})
    private BigDecimal price; // 价格

}
