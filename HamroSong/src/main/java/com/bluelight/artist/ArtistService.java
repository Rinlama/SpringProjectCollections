package com.bluelight.artist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bluelight.exception.ResourceNotFoundException;
import com.bluelight.message.MessageResponse;
import com.bluelight.message.*;


@Service
public class ArtistService {

	@Autowired(required=true)
	ArtistRepository artistRepository;
	
	public List<Artist> GetAllArtist(){
		List<Artist> list= new ArrayList<Artist>();
		artistRepository.findAll().forEach(d->{
			list.add(d);
		});
		return list;
	}
	public Artist GetById(String id){
		 return artistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ArtistId " + id + " not found"));
	}	
	public ResponseEntity<?> addArtist(Artist artist) {
		if(!artistRepository.existsById(artist.getId())){
			 artistRepository.save(artist);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.add("content-type", "application/json");
			 return ResponseEntity.ok().body("ArtistId " + artist.getId() + "Added");
		}else{
			 return ResponseEntity.ok().body("Duplicate Id " + artist.getId() + "Found");
		}
		
	}
	
	public Artist updateArtist(String artistId,Artist artist){
		 return artistRepository.findById(artistId).map(a -> {
	           	a.setLogo(artist.getLogo());
	         	a.setDescription(artist.getDescription());
	         	a.setName(artist.getName());
	            return artistRepository.save(a);
	        }).orElseThrow(() -> new ResourceNotFoundException("ArtistId " + artistId + " not found"));
	}
	public ResponseEntity<?> deleteService(String artistId) {
		return artistRepository.findById(artistId).map(a -> {
	             artistRepository.delete(a);
	            return ResponseEntity.ok().body("ArtistId " + artistId + "Delete");
	        }).orElseThrow(() -> new ResourceNotFoundException("ArtistId " + artistId + " not found"));

		
	}
//	*********************** PAGEABLE  *******************
	public Page<Artist> GetAllArtistByPagebale(Pageable page) {
		return  artistRepository.findAll(page);
	}

}
