package com.example.test.repositories;

import com.example.test.models.AuthCred;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthCredRepository extends JpaRepository<AuthCred, Long> {
	
	//Optional<AuthCred> findByEmail(String email);
	Optional<AuthCred> findById(int id);

	Optional<AuthCred> findByUserName(String s);

//	Optional<AuthCred> findByUserName(String email);


}
