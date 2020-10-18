package com.bluelight.nycproject.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bluelight.nycproject.entity.Post;
import com.bluelight.nycproject.entity.User;
import com.bluelight.nycproject.repository.PostRepository;

@Service
public class PostServices {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getPosts(){
		return postRepository.findAll();
	}
	
	public Optional<Post> getPost(Long id){
		return postRepository.findById(id);
	}
	
	public Post savePost(Post post){
		return postRepository.save(post);
	}
	

	public Post putPost(Long id, Post post) {
		if(postRepository.existsById(id)){
			  post.setPostId(id);
			return postRepository.save(post);
		}else{
			return null;
		}
	}
	public ResponseEntity<?> deletePost(Long id){
		if(postRepository.existsById(id)){
			postRepository.deleteById(id);
			return ResponseEntity.ok().body("Post remove");
		}else{
			return ResponseEntity.ok().body("Post not found");
		}
	}
	
	public List<Post> findUserPost(User user){
		return postRepository.findByUser(user);
	}

}
