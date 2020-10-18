package com.bluelight.nycproject.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bluelight.nycproject.entity.Comment;
import com.bluelight.nycproject.entity.Post;
import com.bluelight.nycproject.repository.CommentRepository;
import com.bluelight.nycproject.repository.PostRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> getPosts(){
		return commentRepository.findAll();
	}
	
	public Optional<Comment> getPost(Long id){
		return commentRepository.findById(id);
	}
	
	public Comment savePost(Comment comment){
		return commentRepository.save(comment);
	}
	

	public Comment putPost(Long id, Comment comments) {
		if(commentRepository.existsById(id)){
			comments.setCommentId(id);
			return commentRepository.save(comments);
		}else{
			return null;
		}
	}
	public ResponseEntity<?> deletePost(Long id){
		if(commentRepository.existsById(id)){
			commentRepository.deleteById(id);
			return ResponseEntity.ok().body("Post remove");
		}else{
			return ResponseEntity.ok().body("Post not found");
		}
	}

}
