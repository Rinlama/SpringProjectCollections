package com.bluelight.song;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

	@Autowired(required=true)
	SongRepository songRepository;
	
	public List<Song> GetAllSong(String artistId){
		List<Song> list= new ArrayList<Song>();
		songRepository.findByArtistId(artistId).forEach(Song->{
			list.add(Song);
		});;
		return list;
	}
}
