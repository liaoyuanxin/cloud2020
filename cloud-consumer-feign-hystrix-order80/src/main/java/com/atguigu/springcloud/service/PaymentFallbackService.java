package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService.paymentInfo_OK()： o(╥﹏╥)o！！！！";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService.paymentInfo_TimeOut: o(╥﹏╥)o！！！！";
    }
}
