package com.bluelight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
