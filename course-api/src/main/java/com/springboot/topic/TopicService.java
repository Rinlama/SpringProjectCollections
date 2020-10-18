package com.springboot.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	public List<Topic> list=new ArrayList<Topic>();
	
	public TopicService(){
		this.list.add(new Topic("1","lama","hello from controller"));
		this.list.add(new Topic("2","lama2","hello from controller2"));
	}
	
	public List<Topic> getAllTopics(){
		return this.list;
	}
	public Topic getTopic(String id){
		return this.list.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		// TODO Auto-generated method stub
		this.list.add(topic);
	}
	
	public void updateTopic(String id,Topic topic){
		for(int i=0; i<this.list.size();i++){
			   if(this.list.get(i).getId().equals(id)){
				   this.list.set(i, topic);
				   return;
			   }
		}
		
	}
	public void deleteTopic(String id){
		for (Topic topic : list) {
			if(topic.getId().equals(id)){
				list.remove(list.indexOf(topic));
				return;
			}
		}	
	}

}
