package hello;

import java.beans.Statement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Calendar;
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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(Application.class);
		@Autowired
    
		JdbcTemplate jdbc;
	    NamedParameterJdbcTemplate jdbcTemplate; // (1)

		
		@PostConstruct public void createTable(){
			
		}
	
		@RequestMapping("/")
		
		public String index(Model model) {
			String[] week_name = {"日曜日", "月曜日", "火曜日", "水曜日", 
                    "木曜日", "金曜日", "土曜日"};

			Calendar calendar = Calendar.getInstance();
			
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day = calendar.get(Calendar.DATE);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			
			int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
			
			model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day", day);
			  model.addAttribute("week", week_name[week]);
			return"name0";
			
		}
		@RequestMapping("/post")
		public String send(Model model, @RequestParam("name1") String name1, @RequestParam("niconico") String niconico, String name0,String n) {
			
			String[] week_name = {"日曜日", "月曜日", "火曜日", "水曜日", 
                    "木曜日", "金曜日", "土曜日"};

			Calendar calendar = Calendar.getInstance();
			
			int year = calendar.get(Calendar.YEAR);//西暦取得
			int month = calendar.get(Calendar.MONTH) + 1;//月取得
			int day = calendar.get(Calendar.DATE);//　日取得
			int hour = calendar.get(Calendar.HOUR_OF_DAY); //時間取得
			int minute = calendar.get(Calendar.MINUTE);// 分取得
			int second = calendar.get(Calendar.SECOND);// 秒取得
			int week = calendar.get(Calendar.DAY_OF_WEEK) - 1; //曜日取得
			
			int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
			
			model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day", day);
			  model.addAttribute("week", week_name[week]);
			  
	        jdbc.update("INSERT INTO user(name1) VALUES (?)",new Object[]{name1} );
	        jdbc.execute("SELECT id, name1 FROM user");
	        
		  model.addAttribute("name1", name1);
		  
		  model.addAttribute("name2", "二郎");
		  model.addAttribute("name3", "nn");
		  model.addAttribute("name4", "naga");
		 
		  System.out.println(niconico);	       
	       List<User> l = jdbc.query(
	                "SELECT id, name1 FROM user",
	                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name1"))
	        );
	       //.forEach(customer -> log.info(customer.toString()));
	        
	       model.addAttribute("user", l);
	       
	    
	       
		  return "name";    
		  
		}
		/*@RequestMapping("/post1")
		public String send1(Model model, @RequestParam("niconico") String niconico ){
			System.out.println(niconico);
			jdbc.query(
	                "SELECT id, first_name, last_name FROM customers",
	                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
	        ).forEach(customer -> log.info(customer.toString()));
			return "name"; 
		}*/

	}
