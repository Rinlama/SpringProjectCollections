package com.bluelight.nycproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.nycproject.entity.Comment;
import com.bluelight.nycproject.entity.Post;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
