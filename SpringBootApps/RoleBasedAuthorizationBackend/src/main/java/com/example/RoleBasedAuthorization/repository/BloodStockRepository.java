package com.example.RoleBasedAuthorization.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RoleBasedAuthorization.entity.BloodStock;

@Repository
public interface BloodStockRepository extends JpaRepository <BloodStock,Integer> {

	BloodStock findStockBybloodgroup(String bloodgroup);



}
