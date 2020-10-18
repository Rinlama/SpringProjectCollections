package com.bluelight.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bluelight.artist.Artist;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="users")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id",nullable=false,updatable=false)
	private Long id; 
	
	@Column(name="firstname",nullable=false,unique=false)
	private String firstname;
	
	@Column(name="lastname",nullable=false,unique=false)
	private String lastname;
	
	@Column(name="username",nullable=false,unique=true)
	private String username;
	
	@JsonIgnore
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="enabled",nullable=false)
	private boolean enabled;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Role> roles;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private List<Artist> ArtistList;
	
	public Long getId() {
		return id;
	}
	
	public List<Artist> getArtistList() {
		return ArtistList;
	}

	public void setArtistList(List<Artist> artistList) {
		ArtistList = artistList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return true;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@JsonIgnore
	public List<Role> getRoles() {
		return roles;
	}
	@JsonProperty
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
		for(Role role:roles){
			String name=role.getName().toUpperCase();
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
