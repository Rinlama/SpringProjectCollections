package com.bluelight.nycproject.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bluelight.nycproject.audit.Auditable;

@Entity
@Table(name="comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment extends Auditable<String> implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="comment_id")
	private Long commentId;
	
	@NotNull
	@Column(name="description")
	@Size(min=3,max=500)
	private String description;
	
	@CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date lastModifiedDate;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String lastModifiedBy;
	
	@Column(name="post_id_fk")
	private long post_id_fk;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Post post;
	
	public Comment() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	

	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public long getPost_id_fk() {
		return post_id_fk;
	}


	public void setPost_id_fk(long post_id_fk) {
		this.post_id_fk = post_id_fk;
	}


	public Long getCommentId() {
		return commentId;
	}


	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	
	
	
	
}
