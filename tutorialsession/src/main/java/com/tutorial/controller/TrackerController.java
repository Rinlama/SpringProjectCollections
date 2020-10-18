package com.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.entity.Tracker;
import com.tutorial.service.TrackerService;

@RestController
public class TrackerController {
	
	@Autowired
	private TrackerService trackerService;

	@RequestMapping(method=RequestMethod.GET,value="/trackers")
	@ResponseStatus(HttpStatus.OK)
	public List<Tracker> getTrackers(){
		return trackerService.getTrackers();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/trackers")
	@ResponseStatus(HttpStatus.CREATED)
	public Tracker AddTracker(@Valid @RequestBody Tracker tracker){
		return trackerService.addTracker(tracker);
	}
}
