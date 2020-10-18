package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String index(@PathVariable("id")String id,Model model){
		
		String name= "hello from Java " + id;
		model.addAttribute("message",name);
		return "hello";
	}
	

}
