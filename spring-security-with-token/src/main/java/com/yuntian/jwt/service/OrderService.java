package com.yuntian.jwt.service;


import com.yuntian.jwt.model.dto.OrderDTO;

/**
 * @author guangleilei.
 * @date Created in 13:57 2020/1/13
 * @description
 */
public interface OrderService {


    Long  createOrder(OrderDTO order);
}
