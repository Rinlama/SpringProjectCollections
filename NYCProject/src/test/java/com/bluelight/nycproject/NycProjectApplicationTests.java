package com.bluelight.nycproject;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bluelight.nycproject.entity.Post;
import com.bluelight.nycproject.entity.User;
import com.bluelight.nycproject.services.PostServices;
import com.bluelight.nycproject.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NycProjectApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PostServices postService;
	
	@org.junit.Before
	public void initDb(){
		{
			User newUser=new User("test@test.com","test","password");
			userService.createUser(newUser);
		}
		{
			User newUser=new User("admin@test.com","admin","password");
			userService.createAdmin(newUser);
		}
		Post post=new Post("name","cat","under","descrotp");
		User user= userService.findOne("test@test.com");
		post.setUser(user);
		postService.savePost(post);
	}
	
	
	@Test
	public void contextLoads() {
		User user= userService.findOne("test@test.com");
		assertNotNull(user);
		User admin= userService.findOne("admin@test.com");
		assertEquals(admin.getEmail(),"admin@test.com");
	}
	
	@Test
	public void testPost(){
		User user= userService.findOne("test@test.com");
		List<Post> post= postService.findUserPost(user);
		assertNotNull(post);
	}

}
