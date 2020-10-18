package com.bluelight.artist;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluelight.message.MessageResponse;

@RestController
@CrossOrigin("*")
public class ArtistController {
	
	@Autowired(required=true)
	ArtistService artistService;
	
	@RequestMapping(method=RequestMethod.GET,value="/artistsByPageable")
	public Page<Artist> getAllArtistByPageable(org.springframework.data.domain.Pageable page){	
		return artistService.GetAllArtistByPagebale(page);
	}

	@RequestMapping(method=RequestMethod.GET,value="/artists")
	public List<Artist> getAllArtist(){	
		return artistService.GetAllArtist();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/artists/{id}")
	public Artist getArtistById(@PathVariable("id") String id){	
		return artistService.GetById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/artists")
	public ResponseEntity<?> AddArtist(@Valid @RequestBody Artist artist){
		return artistService.addArtist(artist);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/artists/{artistId}")
	public ResponseEntity<Artist> UpdateArtist(@Valid @PathVariable("artistId") String artistId,@RequestBody Artist artist){
		Artist a=artistService.updateArtist(artistId,artist);  
		HttpHeaders responseHeaders = new HttpHeaders();
		return ResponseEntity.ok().headers(responseHeaders).body(a);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/artists/{id}")
	public ResponseEntity<?> DeleteArtist(@PathVariable("id")String id){
		return artistService.deleteService(id);
	}
	
	
	 
}
