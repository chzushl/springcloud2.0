package com.mordo.springcloud.service;

import com.mordo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
