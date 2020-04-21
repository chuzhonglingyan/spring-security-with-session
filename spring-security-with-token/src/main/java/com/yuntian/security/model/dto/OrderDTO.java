package com.yuntian.security.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author guangleilei.
 * @date Created in 13:58 2020/1/13
 * @description
 */
@Data
public class OrderDTO {

    private List<GoodSKUDTO> goodSkulist;

    private Long userId;

}
