package com.bluelight.nycproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluelight.nycproject.entity.Post;
import com.bluelight.nycproject.entity.User;

public interface PostRepository extends JpaRepository<Post,Long> {

	public List<Post> findByUser(User user);

}
