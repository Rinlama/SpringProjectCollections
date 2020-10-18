package com.bluelight.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluelight.artist.ArtistService;

@RestController
@CrossOrigin("*")
public class SongController {
	@Autowired(required=true)
	SongService SongService;
	
	@Autowired(required=true)
	ArtistService artistService;

	@RequestMapping(method=RequestMethod.GET,value="/artist/{artistId}/songs")
	public List<Song> getAllSong(@PathVariable(value="artistId") String artistId){	
		return SongService.GetAllSong(artistId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/artist/{artistId}/songs/{songId}")
	public Song getSongById(@PathVariable("songId") String id){	
		return SongService.GetById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/artist/{artistId}/songs")
	public ResponseEntity<String> AddSong(@PathVariable(value="artistId")String artistId,@RequestBody Song Song){
		String value=SongService.addSong(artistId,Song);  
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		return ResponseEntity.ok().headers(responseHeaders).body(value);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/songs/{id}")
	public ResponseEntity<Song> UpdateSong(@PathVariable("id") String id,@RequestBody Song Song){
		SongService.updateSong(Song);  
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(Song);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/songs/{id}")
	public void DeleteSong(@PathVariable("id")String id){
		SongService.deleteService(id);
	}
	
	
}
