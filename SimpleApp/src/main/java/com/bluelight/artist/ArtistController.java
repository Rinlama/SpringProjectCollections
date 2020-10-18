package com.bluelight.artist;

import java.util.*;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model model){
		List<Artist> list= new ArrayList<>();
		list.add(new Artist("1","name","sub"));
		model.addAttribute("Item",list);
		return "artist";
	}
}
