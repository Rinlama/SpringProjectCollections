package com.bluelight.nycproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@Email
	@NotEmpty
	@Column(unique=true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min=4)
	private String password;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Post> post;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="User_Roles",joinColumns={
			@JoinColumn(name="USER_Email",referencedColumnName="email")
	},inverseJoinColumns={@JoinColumn(name="ROLE_NAME",referencedColumnName="NAME")})
	private List<Role> roles;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(@Email @NotEmpty String email, @NotEmpty String name, @Size(min = 4) String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Post> getPost() {
		return post;
	}
	public void setPost(List<Post> post) {
		this.post = post;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
