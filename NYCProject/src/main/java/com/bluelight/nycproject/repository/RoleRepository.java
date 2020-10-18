package com.bluelight.nycproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.nycproject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
