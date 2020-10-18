package com.bluelight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByUsername(String username);
}
