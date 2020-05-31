package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        if (result > 0) {
            return new CommonResult(200, "插入数据成功,server.port=" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            return new CommonResult(200, "查询数据成功,server.port=" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询数据失败,没有记录为：" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymengLB() {
        return this.serverPort;
    }
}
