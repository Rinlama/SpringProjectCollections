package com.bluelight.song;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluelight.artist.Artist;

@RestController
@CrossOrigin("*")
public class SongController {

	@Autowired
	SongService songService;
	

	@RequestMapping(method=RequestMethod.GET,value="/artist/{artistId}/songs")
	public List<Song> getAllSongs(@PathVariable String artistId){
		return songService.GetAllSong(artistId);
	}

}
