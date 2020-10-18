package com.bluelight.artist;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.assertj.core.internal.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bluelight.fileStorage.FileStorageService;
import com.bluelight.fileStorage.UploadFileResponse;
import com.bluelight.model.Role;
import com.bluelight.model.User;
import com.bluelight.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class ArtistController {
	
	@Autowired(required=true)
	ArtistService artistService;
	
	@Qualifier("userDetailsService")
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private FileStorageService fileStorageService;
	    
	
	@RequestMapping(method=RequestMethod.GET,value="/")
	public String index(){	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User customUser = (User)authentication.getPrincipal();
		long userId = customUser.getId();
		String name = authentication.getName();
		List<Role> role=customUser.getRoles();
		
		UserDetails s=userDetailsService.loadUserByUsername("var");
		return userId + "-" + name + " rike" + role.get(0).getName();
	}
	
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
	
//	@RequestMapping(method=RequestMethod.POST,value="/artists")
//	public ResponseEntity<?> AddArtist(@Valid @RequestBody Artist artist){
//		return artistService.addArtist(artist);
//	}
	
	@RequestMapping(method=RequestMethod.POST,value="/artists")
	public UploadFileResponse fileupload(@RequestParam("name") String name,@RequestParam("userId") 
	String userId,@RequestParam("description") String description,@RequestParam("file") MultipartFile file){
		
		    String fileName = fileStorageService.storeFile(file);
	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
	        
	        String fileViewUri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(fileName).toUriString();
	        
	        Artist artist= new Artist();
	        artist.setName(name);
	        artist.setDescription(description);
	        artist.setLogo(fileViewUri);
	        artist.setUserId(userId);
	        artistService.addArtist(artist);

	        return new UploadFileResponse(fileName,fileViewUri, fileDownloadUri,file.getContentType(), file.getSize());
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
	
	@RequestMapping(method=RequestMethod.GET,value="/artist/categorybyname")
	public ResponseEntity<?> GETCategory(){
		return artistService.GETCategory();
	}
	
	 
}
