package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BloodStock;

@Repository
public interface BloodStockRepository extends JpaRepository<BloodStock, Integer>{

}
