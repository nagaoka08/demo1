package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;;

@Controller
public class IndexController {
	
		@RequestMapping("/")
		public String index() {
			//System.out.println("hello");
			return"index";
			
		}
		@RequestMapping("/post")
		public String send(Model model, @RequestParam("name") String name) {
		  model.addAttribute("name", name);
		  System.out.println(name);
		  return "name";    
		}

	}
