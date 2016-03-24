package hello;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.jdbc.core.JdbcTemplate;


@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
		@Autowired
    
		JdbcTemplate jdbc;
		
		@PostConstruct public void createTable(){
			
		}
	
		@RequestMapping("/")
		
		public String index() {
			//System.out.println("hello");
			return"name0";
			
		}
		@RequestMapping("/post")
		
		/*public void create(@RequestParam String first_Name) {
			System.out.println("hello");
	        jdbc.update("insert into customers (first_Name) values (?)", first_Name);
	    }
		public void create1(@RequestParam String last_Name) {
			System.out.println("hello");
	        jdbc.update("insert into customers (last_Name) values (?)", last_Name);
	    }*/
		public String send(Model model, @RequestParam("first_Name") String first_Name,@RequestParam("last_Name") String last_Name,String name0) {
			System.out.println("hello");
			List<Object[]> splitUpNames = Arrays.asList("Jeff Dean", "Josh Bloch", "Josh Long","test1891 test21").stream()
	                .map(name -> name.split(" "))
	                .collect(Collectors.toList());
			splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
	        //jdbc.update("insert into customers (first_Name) values (?)", first_Name);
	       // jdbc.update("insert into customers (last_Name) values (?)", last_Name);
	        jdbc.update("INSERT INTO customers(first_name, last_name) VALUES (?,?)",new Object[]{first_Name,last_Name} );
	        name0=first_Name+last_Name;
		  model.addAttribute("name0", name0);
		  model.addAttribute("last_Name", last_Name);
		  model.addAttribute("name1", "太郎");
		  model.addAttribute("name2", "二郎");
		  model.addAttribute("name3", "長岡");
		  model.addAttribute("name4", "直樹");
		  System.out.println(first_Name);
		  log.info("Querying for customer records where first_name = first_Name:");
	        jdbc.query(
	                "SELECT id, first_name, last_name FROM customers WHERE first_Name = ?", new Object[] { first_Name},
	                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
	        ).forEach(customer -> log.info(customer.toString()));
		  return "name";    
		}

	}
