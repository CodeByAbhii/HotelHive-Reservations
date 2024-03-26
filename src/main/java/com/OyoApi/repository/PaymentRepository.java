package com.OyoApi.repository;

import com.OyoApi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment ,Long> {
}
