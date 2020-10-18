package com.learnspring.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
	public List<Course> list=new ArrayList<Course>();
	
	@Autowired(required=true)
	 CourseRepository topicRepository;
	
	public CourseService(){
	}
	
	public List<Course> getAllCourses(String topicid){
		//return this.list;
		List<Course> courses= new ArrayList<>();
		topicRepository.findByTopicId(topicid).forEach(data->{
			courses.add(data);
		});;
		return courses;
//		topicRepository.findAll().forEach(e->{
//			if(e.getId().equals(topicid)){
//				topics.add(e);
//			}
//		});
//		return topics;
	}
	public Course getCourse(String id){
		return topicRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		topicRepository.save(course);
	}
	
	public void updateCourse(Course course){
		topicRepository.save(course);
		
	}
	public void deleteCourse(String id){
		topicRepository.deleteById(id);
	}

}
