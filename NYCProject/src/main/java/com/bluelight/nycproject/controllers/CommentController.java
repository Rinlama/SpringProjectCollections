package com.bluelight.nycproject.controllers;

import java.util.List;
import java.util.Optional;

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

import com.bluelight.nycproject.entity.Comment;
import com.bluelight.nycproject.repository.PostRepository;
import com.bluelight.nycproject.services.CommentService;
import com.bluelight.nycproject.services.PostServices;

@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	
	@GetMapping("/comments")
	@ResponseStatus(HttpStatus.OK)
	public List<Comment> getComments(){
		
		return commentService.getPosts();
	}
	
	@GetMapping("/comments/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Comment> getCommentbyId(@PathVariable("id") Long id){
		return commentService.getPost(id);
	}
	
	@PostMapping("/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public Comment saveComment(@Valid @RequestBody Comment post){
	    return commentService.savePost(post);
	}
	
	
	@PutMapping("/comments/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Comment modifyComment(@PathVariable("id") Long id,@Valid @RequestBody Comment post){
	   return commentService.putPost(id,post);
	}
	
	@DeleteMapping("/comments/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<?> removeComment(@PathVariable("id") Long id){
		 return commentService.deletePost(id);
	}
	
}
