package com.bluelight.song;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bluelight.artist.Artist;

public interface SongRepository extends CrudRepository<Song, String> {

	public List<Song> findByArtistId(String artistId);
}
