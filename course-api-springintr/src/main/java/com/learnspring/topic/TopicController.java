package com.learnspring.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(method=RequestMethod.GET,value="/topics")
	public ResponseEntity<List<Topic> >getAllTopics(){
		 HttpHeaders headers = new HttpHeaders();
	     headers.add("Responded", "TopicController");
	     
	     return ResponseEntity.ok().headers(headers).body(topicService.getAllTopics());
	//return topicService.getAllTopics();
	}
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public ResponseEntity addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);  
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(topic);
	
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id){
		topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}
}
