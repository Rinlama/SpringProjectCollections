package com.bluelight.nycproject.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bluelight.nycproject.audit.Auditable;

@Entity
@Table(name="post")
@EntityListeners(AuditingEntityListener.class)
public class Post extends Auditable<String>  implements Serializable   {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private long postId; 
	
	@NotNull
	@Size(min=3,max=100)
	@Column(name="name")
	private String name;
	
	@NotNull
	@Size(min=3, max=100)
	@Column(name="category")
	private String category;
	
	@NotNull
	@Size(min=3, max=50)
	@Column(name="price")
	private String price;
	
	@NotNull
	@Size(min=3, max=50)
	@Column(name="description")
	private String description;
	
	@CreatedDate
	private Date createdDate;
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String lastModifiedBy;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="post_id_fk",referencedColumnName="post_id")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	

	public Post(@NotNull @Size(min = 3, max = 100) String name, @NotNull @Size(min = 3, max = 100) String category,
			@NotNull @Size(min = 3, max = 50) String price, @NotNull @Size(min = 3, max = 50) String description) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Post() {
		super();   
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public long getPostId() {
		return postId;
	}


	public void setPostId(long postId) {
		this.postId = postId;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Post [id=" + postId + ", name=" + name + ", category=" + category + ", price=" + price + ", description="
				+ description + "]";
	}
	
}
