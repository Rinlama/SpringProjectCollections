package com.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.entity.Tracker;
import com.tutorial.repository.TrackerRepository;

@Service
public class TrackerService {

	@Autowired
	private TrackerRepository trackerRepo;
	
	public List<Tracker> getTrackers(){
		return trackerRepo.findAll();
	}
	public Tracker addTracker(Tracker tracker){
		return trackerRepo.save(tracker);
	}

}
