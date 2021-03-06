package hello;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {
	private static final Logger log = LoggerFactory.getLogger(Application.class);


		@Autowired

		JdbcTemplate jdbc;
	    NamedParameterJdbcTemplate jdbcTemplate; // (1)


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

		String Day = month+"月"+day1+"日"+week_name[week]; //月日曜日表示
		int nowMonth = calendar.get(Calendar.MONTH) + 1;
		int lastDay = calendar.getActualMaximum(Calendar.DATE);





		@RequestMapping("/")


		public String index(Model model) {
			int number0=0;
			int number1=1;
			int number2=2;
			int number3=3;
			int number4=4;
			model.addAttribute("number0", number0);
			model.addAttribute("number1", number1);
			model.addAttribute("number2", number2);
			model.addAttribute("number3", number3);
			model.addAttribute("number4", number4);
			//カレンダー
			  model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day1", day1);
			  model.addAttribute("week", week_name[week]);

			  model.addAttribute("day", Day);

			  model.addAttribute("nowMonth", nowMonth);
			  model.addAttribute("lastDay",lastDay);



			  List<Account> account = jdbc.query(
		                "SELECT id,username FROM account",
		                (rs, rowNum) -> new Account( rs.getInt("id"),rs.getString("username"))
		        );

		       	  model.addAttribute("account", account);
		       	List<Feelings> feelings = jdbc.query(
		                "SELECT id,year,month,day,niconico FROM feelings where year=? and month=? ",
		                (rs, rowNum) -> new Feelings(rs.getInt("id"),rs.getInt("year"),rs.getInt("month"),rs.getInt("day"),rs.getInt("niconico")), year, month
		        );
		        model.addAttribute("feelings", feelings);

			return"name";

		}
		@RequestMapping("/account")
		public String send(Model model, @RequestParam("name") String name	) {


			int number0=0;
			int number1=1;
			int number2=2;
			int number3=3;
			int number4=4;
			model.addAttribute("number0", number0);
			model.addAttribute("number1", number1);
			model.addAttribute("number2", number2);
			model.addAttribute("number3", number3);
			model.addAttribute("number4", number4);
			  int r =0;
			  r = (int)(Math.random() * 10000) + 1;


			  //ユーザデータベース処理
	        jdbc.update("INSERT INTO account(id,username) VALUES (?,?)",new Object[]{r,name});




	        model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day1", day1);
			  model.addAttribute("week", week_name[week]);

			  model.addAttribute("day", Day);

			  model.addAttribute("nowMonth", nowMonth);
			  model.addAttribute("lastDay",lastDay);



			  List<Account> account = jdbc.query(
		                "SELECT id,username FROM account",
		                (rs, rowNum) -> new Account( rs.getInt("id"),rs.getString("username"))
		        );

		       	  model.addAttribute("account", account);
		       	List<Feelings> feelings = jdbc.query(
		                "SELECT id,year,month,day,niconico FROM feelings where year=? and month=? ",
		                (rs, rowNum) -> new Feelings(rs.getInt("id"),rs.getInt("year"),rs.getInt("month"),rs.getInt("day"),rs.getInt("niconico")), year, month
		        );
		        model.addAttribute("feelings", feelings);

		  return "name";

		}
		@RequestMapping("/niconico")
		public String send1(Model model, @RequestParam("niconico1") int niconico1,@RequestParam("id") String id,@RequestParam("id") int nicoid ){
			int number0=0;
			int number1=1;
			int number2=2;
			int number3=3;
			int number4=4;
			model.addAttribute("number0", number0);
			model.addAttribute("number1", number1);
			model.addAttribute("number2", number2);
			model.addAttribute("number3", number3);
			model.addAttribute("number4", number4);

			//カレンダー
			 model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day1", day1);
			  model.addAttribute("week", week_name[week]);
			  model.addAttribute("lastDay",lastDay);


			  model.addAttribute("day", Day);



			List<Account> account = jdbc.query(
	                "SELECT id,username FROM account",
	                (rs, rowNum) -> new Account( rs.getInt("id"),rs.getString("username"))
	        );

	       	  model.addAttribute("account", account);

	       	int id1 = Integer.parseInt(id);

	       	int count =jdbc.queryForObject("select count(*) from feelings where id=? and year=? and month=? and day=?",Integer.class,id1,year,month,day1);




	       	  if(count == 0){
	       		jdbc.update("INSERT INTO feelings(id,year,month,day,niconico) VALUES (?,?,?,?,?)",new Object[]{id1,year,month,day1,niconico1});


	       	  }

	       	  else {

	       		jdbc.update("update feelings set niconico=? where id=? and year=? and month=? and day=? ", niconico1, id1,year,month,day1);
	       	  }

	       	List<Feelings> feelings = jdbc.query(
	                "SELECT id,year,month,day,niconico FROM feelings where year=? and month=? ",
	                (rs, rowNum) -> new Feelings(rs.getInt("id"),rs.getInt("year"),rs.getInt("month"),rs.getInt("day"),rs.getInt("niconico")), year, month
	        );
		        model.addAttribute("feelings", feelings);


			return "name";
		}
		@RequestMapping("/delete")
		public String delete(Model model, @RequestParam("id") String id	) {
			int number0=0;
			int number1=1;
			int number2=2;
			int number3=3;
			int number4=4;
			model.addAttribute("number0", number0);
			model.addAttribute("number1", number1);
			model.addAttribute("number2", number2);
			model.addAttribute("number3", number3);
			model.addAttribute("number4", number4);
			//カレンダー
			  model.addAttribute("year", year);
			  model.addAttribute("month", month);
			  model.addAttribute("day1", day1);
			  model.addAttribute("week", week_name[week]);
			  model.addAttribute("lastDay",lastDay);


			  model.addAttribute("day", Day);
			  int r =0;
			  r = (int)(Math.random() * 1000) + 1;

			  int id1 = Integer.parseInt(id);

	        jdbc.update("DELETE  FROM account where id=?",  id1);
	        jdbc.update("DELETE  FROM feelings where id=?",  id1);
	        List<Account> account = jdbc.query(
	                "SELECT id,username FROM account",
	                (rs, rowNum) -> new Account( rs.getInt("id"),rs.getString("username"))
	        );

	       	  model.addAttribute("account", account);



	       //ニコニコデータベース



	       	List<Feelings> feelings = jdbc.query(
	                "SELECT id,year,month,day,niconico FROM feelings where year=? and month=? ",
	                (rs, rowNum) -> new Feelings(rs.getInt("id"),rs.getInt("year"),rs.getInt("month"),rs.getInt("day"),rs.getInt("niconico")), year, month
	        );
	        model.addAttribute("feelings", feelings);




		  return "name";

		}

		@RequestMapping(value = "/previous")
		public String getPrevious(Model model, @RequestParam("previous") String previous) {
			int number0=0;
			int number1=1;
			int number2=2;
			int number3=3;
			int number4=4;
			model.addAttribute("number0", number0);
			model.addAttribute("number1", number1);
			model.addAttribute("number2", number2);
			model.addAttribute("number3", number3);
			model.addAttribute("number4", number4);
			String[] prev = previous.split("/");
			int prevYear = Integer.parseInt(prev[0]);
			int prevMonth = Integer.parseInt(prev[1]);
			if (prevMonth == 0) {
				prevYear -= 1;
				prevMonth = 12;
			}
			model.addAttribute("year", prevYear);
			model.addAttribute("month", prevMonth);

			Calendar calendar = Calendar.getInstance();

			// 現在選択中のさくせんがあればそのnumberを送る.
			int nowYear = calendar.get(Calendar.YEAR);
			int nowMonth = calendar.get(Calendar.MONTH) + 1;
			int nowDay = calendar.get(Calendar.DATE);
			int count = jdbc.queryForObject(
					"select count(*) from feelings where year=? and month=? and day=?", Integer.class, nowYear,
					nowMonth, nowDay);
			if (count == 1) {
				String content = jdbc.queryForObject(
						"select content from operation_history_tbl where year=? and month=? and day=?", String.class,
						nowYear, nowMonth, nowDay);
				int number = jdbc.queryForObject("select number from operation_list where content=?", Integer.class,
						content);
				model.addAttribute("number", number);
			}

			calendar.set(prevYear, prevMonth - 1, 1);
			int lastDay = calendar.getActualMaximum(Calendar.DATE);
			model.addAttribute("lastDay", lastDay);

			 List<Account> account = jdbc.query(
		                "SELECT id,username FROM account",
		                (rs, rowNum) -> new Account( rs.getInt("id"),rs.getString("username"))
		        );

		       	  model.addAttribute("account", account);
		       	List<Feelings> feelings = jdbc.query(
		                "SELECT id,year,month,day,niconico FROM feelings where year=? and month=? order by day",
		                (rs, rowNum) -> new Feelings(rs.getInt("id"),rs.getInt("year"),rs.getInt("month"),rs.getInt("day"),rs.getInt("niconico")), prevYear, prevMonth
		        );
		        model.addAttribute("feelings", feelings);



			return "name";
		}
		@RequestMapping(value = "/next")
		public String getNext(Model model, @RequestParam("next") String next) {
			int number0=0;
			int number1=1;
			int number2=2;
			int number3=3;
			int number4=4;
			model.addAttribute("number0", number0);
			model.addAttribute("number1", number1);
			model.addAttribute("number2", number2);
			model.addAttribute("number3", number3);
			model.addAttribute("number4", number4);
			String[] nex = next.split("/");

			int nexYear = Integer.parseInt(nex[0]);
			int nexMonth = Integer.parseInt(nex[1]);
			if (nexMonth == 13) {
				nexYear += 1;
				nexMonth = 1;
			}
			model.addAttribute("year", nexYear);
			model.addAttribute("month", nexMonth);

			Calendar calendar = Calendar.getInstance();

			// 現在選択中のさくせんがあればそのnumberを送る.
			int nowYear = calendar.get(Calendar.YEAR);
			int nowMonth = calendar.get(Calendar.MONTH) + 1;
			int nowDay = calendar.get(Calendar.DATE);
			int count = jdbc.queryForObject(
					"select count(*) from feelings where year=? and  month=? and day=?", Integer.class, nowYear,
					nowMonth, nowDay);
			if (count == 1) {
				String content = jdbc.queryForObject(
						"select content from feelings where year=? and month=? and day=?", String.class,
						nowYear, nowMonth, nowDay);
				int number = jdbc.queryForObject("select number from feelings where content=?", Integer.class,
						content);
				model.addAttribute("number", number);
			}

			calendar.set(nexYear, nexMonth - 1, 1);
			int lastDay = calendar.getActualMaximum(Calendar.DATE);
			model.addAttribute("lastDay", lastDay);

			 List<Account> account = jdbc.query(
		                "SELECT id,username FROM account",
		                (rs, rowNum) -> new Account( rs.getInt("id"),rs.getString("username"))
		        );

		       	  model.addAttribute("account", account);
		       	List<Feelings> feelings = jdbc.query(
		                "SELECT id,year,month,day,niconico FROM feelings where year=? and month=? order by day",
		                (rs, rowNum) -> new Feelings(rs.getInt("id"),rs.getInt("year"),rs.getInt("month"),rs.getInt("day"),rs.getInt("niconico")), nexYear, nexMonth
		        );
		        model.addAttribute("feelings", feelings);


			return "name";
		}
//

	}