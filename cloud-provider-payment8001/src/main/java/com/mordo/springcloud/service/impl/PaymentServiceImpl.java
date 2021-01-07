package com.mordo.springcloud.service.impl;

import com.mordo.springcloud.dao.PaymentDao;
import com.mordo.springcloud.entities.Payment;
import com.mordo.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
   @Autowired
   private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
