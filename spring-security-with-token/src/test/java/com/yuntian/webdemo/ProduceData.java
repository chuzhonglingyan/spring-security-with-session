package com.yuntian.webdemo;

import com.alibaba.fastjson.JSON;
import com.yuntian.jwt.model.dto.GoodSKUDTO;
import com.yuntian.jwt.model.dto.OrderDTO;
import com.yuntian.jwt.util.SnowIdUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guangleilei.
 * @date Created in 14:35 2020/1/13
 * @description
 */
@Slf4j
public class ProduceData {

    @Test
    void createTestData() {
        OrderDTO orderDTO=new OrderDTO();
        List<GoodSKUDTO> goodSKUDTOS=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Long skuId= SnowIdUtils.uniqueLong();
            for (int j = 0; j < 3; j++) {
                GoodSKUDTO goodSKUDTO=new GoodSKUDTO();
                goodSKUDTO.setSkuId(skuId);
                goodSKUDTOS.add(goodSKUDTO);
            }
        }
        orderDTO.setGoodSkulist(goodSKUDTOS);
        orderDTO.setUserId(SnowIdUtils.uniqueLong());
        log.info(JSON.toJSONString(orderDTO));
    }

    @Test
    void testKK() {


    }

}
