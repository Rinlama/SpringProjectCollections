package com.bluelight.nycproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.nycproject.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByNameLike(String name);



}
