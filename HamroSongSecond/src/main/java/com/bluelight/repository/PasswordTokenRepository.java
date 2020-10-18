package com.bluelight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.model.PasswordResetToken;
import com.bluelight.model.User;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

	public PasswordResetToken findByToken(String token);
}
