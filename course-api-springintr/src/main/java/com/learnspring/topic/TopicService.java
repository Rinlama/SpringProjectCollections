package com.learnspring.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class TopicService {
	public List<Topic> list=new ArrayList<Topic>();
	
	@Autowired(required=true)
	 TopicRepository topicRepository;
	
	public TopicService(){
	}
	
	public List<Topic> getAllTopics(){
		//return this.list;
		List<Topic> topics= new ArrayList<>();
		topicRepository.findAll().forEach(e->{
			topics.add(e);
		});
		return topics;
	}
	public Topic getTopic(String id){
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		 topicRepository.save(topic);
	}
	
	public void updateTopic(String id,Topic topic){
		topicRepository.save(topic);
		
	}
	public void deleteTopic(String id){
		topicRepository.deleteById(id);
	}

}
