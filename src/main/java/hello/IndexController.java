package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;;

@Controller
public class IndexController {
	
		@RequestMapping("/")
		public String index() {
			System.out.println("hello");
			return"index";
			
		}
		@RequestMapping(value="/post", method=RequestMethod.POST)
		public String index1() {
			System.out.println("hello");
			
	        return "index";
	    }

	}
