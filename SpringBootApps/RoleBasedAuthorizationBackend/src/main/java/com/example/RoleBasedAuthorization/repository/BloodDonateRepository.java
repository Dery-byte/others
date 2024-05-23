package com.example.RoleBasedAuthorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RoleBasedAuthorization.entity.BloodDonate;

@Repository
public interface BloodDonateRepository extends JpaRepository <BloodDonate, Integer> {

}
