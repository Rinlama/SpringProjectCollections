package com.bluelight.artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bluelight.exception.ResourceNotFoundException;


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
		if(!artistRepository.existsById(artist.getArtistId())){
			 artistRepository.save(artist);
				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.add("content-type", "application/json");
			 return ResponseEntity.ok().body("ArtistId " + artist.getArtistId() + "Added");
		}else{
			 return ResponseEntity.ok().body("Duplicate Id " + artist.getArtistId() + "Found");
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
	
//	*********************** CUSTOM QUERY  *******************
	
	public ResponseEntity<?> GETCategory() {
		// TODO Auto-generated method stub
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
			
		Map<String, List<Artist>> data = new HashMap<String, List<Artist>>();
	    data.put( "ZerotoNine",artistRepository.GetZeroToNine());
	    data.put( "AtoG",artistRepository.GetAToG());
	    data.put( "HtoN",artistRepository.GetHToN());
	    data.put( "OtoU",artistRepository.GetOToU());
	    data.put( "VtoZ",artistRepository.GetVToZ());
		
		return ResponseEntity.ok().headers(responseHeaders).body(data);
	}

}
