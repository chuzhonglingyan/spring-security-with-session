package com.yuntian.jwt.model.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author guangleilei.
 * @date Created in 13:58 2020/1/13
 * @description
 */
@Data
public class GoodSKU {

    private Long skuId;

    private String name;

    private BigDecimal price;


}
