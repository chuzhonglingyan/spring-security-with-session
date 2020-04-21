package com.yuntian.security.service.impl;



import com.yuntian.security.model.dto.GoodSKUDTO;
import com.yuntian.security.model.dto.OrderDTO;
import com.yuntian.security.model.entity.GoodSKU;
import com.yuntian.security.service.OrderService;
import com.yuntian.security.util.SnowIdUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author guangleilei.
 * @date Created in 13:57 2020/1/13
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {



    @Override
    public Long createOrder(OrderDTO orderDTO) {
        List<GoodSKUDTO> skuIdList=orderDTO.getGoodSkulist();
        List<GoodSKU> goodSKUSInfo=new ArrayList<>();
        for (int i = 0; i < skuIdList.size(); i++) {
            GoodSKUDTO goodSKUDTO=skuIdList.get(i);
            GoodSKU goodSKU=new GoodSKU();
            goodSKU.setSkuId(goodSKUDTO.getSkuId());
            goodSKU.setName("商品"+i);
            goodSKU.setPrice(new BigDecimal(10));
            goodSKUSInfo.add(goodSKU);
        }
        try {
            Thread.sleep(200+ThreadLocalRandom.current().nextInt(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  SnowIdUtils.uniqueLong();
    }



}
