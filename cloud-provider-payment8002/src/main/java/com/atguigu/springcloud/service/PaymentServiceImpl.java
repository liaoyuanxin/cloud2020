package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return this.paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return this.paymentDao.getPaymentById(id);
    }
}
