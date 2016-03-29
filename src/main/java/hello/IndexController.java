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

		@RequestMapping("/")
		
		public String index(Model model) {
			
				 
			
			
			
			String[] week_name = {"日曜日", "月曜日", "火曜日", "水曜日", 
                    "木曜日", "金曜日", "土曜日"};

			Calendar calendar = Calendar.getInstance();
			
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DATE);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			
			int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
			
			model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day1", day1);
			  model.addAttribute("week", week_name[week]);
			return"name0";
			
		}
		@RequestMapping("/post")
		public String send(Model model, @RequestParam("name1") String name1	) {
			//カレンダー取得
			String[] week_name = {"日曜日", "月曜日", "火曜日", "水曜日", 
                    "木曜日", "金曜日", "土曜日"};

			Calendar calendar = Calendar.getInstance();
			
			int year = calendar.get(Calendar.YEAR);//西暦取得
			int month = calendar.get(Calendar.MONTH) + 1;//月取得
			int day1 = calendar.get(Calendar.DATE);//　日取得
			int hour = calendar.get(Calendar.HOUR_OF_DAY); //時間取得
			int minute = calendar.get(Calendar.MINUTE);// 分取得
			int second = calendar.get(Calendar.SECOND);// 秒取得
			int week = calendar.get(Calendar.DAY_OF_WEEK) - 1; //曜日取得
			
			int day_of_year = calendar.get(Calendar.DAY_OF_YEAR);
			
			  model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day1", day1);
			  model.addAttribute("week", week_name[week]);
			  
			  int[] day2 =new int[31];
			  //ユーザデータベース処理
	        jdbc.update("INSERT INTO user(name1) VALUES (?)",new Object[]{name1} );
	        jdbc.execute("SELECT id, name1 FROM user");
	        
			  model.addAttribute("name1", name1);
			  model.addAttribute("day1", "day1");
			  model.addAttribute("name3", "nn");
			  model.addAttribute("name4", "naga");
			  	      
	       List<User> l = jdbc.query(
	                "SELECT id, name1 FROM user",
	                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name1"))
	        );
	               
	       	  model.addAttribute("user", l);
	       
	       //ニコニコデータベース
	      
	       
	       
	       
	       
		  return "name";    
		  
		}
		@RequestMapping("/post1")
		public String send1(Model model, @RequestParam("niconico1") String niconico1,@RequestParam("name2") String name2 ){
			List<User> l = jdbc.query(
	                "SELECT id, name1 FROM user",
	                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("name1"))
	        );
	               
	       	  model.addAttribute("user", l);
			System.out.println(niconico1);
			System.out.println(name2);
			 jdbc.update("INSERT INTO niconico(name2,niconico1) VALUES (?,?)",new Object[]{name2,niconico1} );
		        jdbc.execute("SELECT id,niconico1 FROM niconico");
		        
		        List<Niconico> h = jdbc.query(
		                "SELECT id, name2,niconico1 FROM niconico",
		                (rs, rowNum) -> new Niconico(rs.getLong("id"), rs.getString("name2"),rs.getString("niconico1"))
		        );
		               
		       	  model.addAttribute("niconi", h);
			return "name"; 
		}

	}