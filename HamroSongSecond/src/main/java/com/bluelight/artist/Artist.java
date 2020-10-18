package com.bluelight.artist;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bluelight.song.Song;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Artist {
	
	public Artist() {
		super();
		this.artistId = UUID.randomUUID().toString();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="artist_id")
	private String artistId;
	private String name;
	private String logo;
	private String description;
	@CreatedDate
	private LocalDateTime dateCreated;
	@LastModifiedDate
	private LocalDateTime dateModified;
	
	@Column(name="user_id")
	private String userId;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="artist_id",referencedColumnName="artist_id")
	private List<Song> song;

	public Artist(String id, String name, String logo, String description) {
		super();
		this.artistId = id;
		this.name = name;
		this.logo = logo;
		this.description = description;
	}
	public String getArtistId() {
		return artistId;
	}
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getDateModified() {
		return dateModified;
	}
	public void setDateModified(LocalDateTime dateModified) {
		this.dateModified = dateModified;
	}
	public List<Song> getSong() {
		return song;
	}
	public void setSong(List<Song> song) {
		this.song = song;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
