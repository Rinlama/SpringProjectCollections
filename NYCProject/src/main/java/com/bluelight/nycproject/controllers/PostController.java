package com.bluelight.nycproject.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bluelight.nycproject.entity.Post;
import com.bluelight.nycproject.repository.PostRepository;
import com.bluelight.nycproject.services.PostServices;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")

public class PostController {
	
	@Autowired
	private PostServices postService;

	
	@GetMapping("/posts")
	@ResponseStatus(HttpStatus.OK)
	@Transactional
	public List<Post> getPosts(){
		
		return postService.getPosts();
	}
	
	@GetMapping("/posts/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Post> getPosts(@PathVariable("id") Long id){
		return postService.getPost(id);
	}
	
	@PostMapping("/posts")
	@ResponseStatus(HttpStatus.CREATED)
	public Post savePost(@Valid @RequestBody Post post){
	    return postService.savePost(post);
	}
	
	
	@PutMapping("/posts/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Post modifyPost(@PathVariable("id") Long id,@Valid @RequestBody Post post){
	   return postService.putPost(id,post);
	}
	
	@DeleteMapping("/posts/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<?> removeStatus(@PathVariable("id") Long id){
		 return postService.deletePost(id);
	}
	
}
