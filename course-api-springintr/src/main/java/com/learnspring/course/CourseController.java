package com.learnspring.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method=RequestMethod.GET,value="/topics/{topicid}/courses")
	public List<Course> getAllCourses(@PathVariable("topicid") String topicid){
	return courseService.getAllCourses(topicid);
	}
	@RequestMapping("/topics/{topicid}/courses/{id}")
	public Course getCourse(@PathVariable("id") String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicid}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable("topicid") String topicid){
		course.setTopic(new Topic(topicid,"",""));
		courseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicid}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicid){
		course.setTopic(new Topic(topicid,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicid}/courses/{id}")
	public void deleteTopic(@PathVariable String id){
		courseService.deleteCourse(id);
	}
}
