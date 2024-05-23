package com.example.blogApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blogApp.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users ,Long> {

	Optional<Users> findByUserName(String username);

}
