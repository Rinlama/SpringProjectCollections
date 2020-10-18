package com.bluelight.song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluelight.artist.*;

@Service
public class SongService {

	@Autowired(required=true)
	SongRepository SongRepository;
	
	@Autowired(required=true)
	ArtistRepository ArtistRepository;
	
	public List<Song> GetAllSong(String artistId){
		List<Song> list= new ArrayList<Song>();
		SongRepository.findByArtistId(artistId).forEach(song->{
			list.add(song);
		});
		return list;
	}
	public Song GetById(String id){
		 return SongRepository.findById(id).orElse(null);
	}	
	public String addSong(String ArtistId,Song song) {
		String message="";
		  if(!SongRepository.existsById(song.getId())){
				ArtistRepository.findById(ArtistId).map(artist->{
					song.setArtist(artist);
					SongRepository.save(song);
					return null;
				});
		
			  message = "success";
		  }else{
			  message= "duplicate";
		  }
		return message;
	}
	
	public void updateSong(Song Song){
		SongRepository.save(Song);
		
	}
	public void deleteService(String id) {
		SongRepository.deleteById(id);
		
	}
}
