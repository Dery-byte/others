package com.mudita.os.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mudita.os.api.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
