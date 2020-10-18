package com.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.entity.Tracker;


public interface TrackerRepository extends JpaRepository<Tracker, Integer> {

	
}