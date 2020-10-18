package com.bluelight.song;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, String> {

	public List<Song> findByArtistId(String artist);
}
