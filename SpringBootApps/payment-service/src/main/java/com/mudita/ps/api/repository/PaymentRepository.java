package com.mudita.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mudita.ps.api.entity.Payment;

@Repository
public interface PaymentRepository  extends JpaRepository <Payment, Integer>{

}
