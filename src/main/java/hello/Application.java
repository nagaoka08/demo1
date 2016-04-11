package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {

        SpringApplication.run(Application.class, args);
        System.out.println("処理終了");


    }

    @Autowired

    JdbcTemplate jdbcTemplate;

    @Override

    public void run(String... strings) throws Exception {



        log.info("Creating tables");
//        //ユーザテーブル作成
//          jdbcTemplate.execute("DROP TABLE account IF EXISTS");
//        jdbcTemplate.execute("CREATE TABLE account(" +
//                "id INT, user VARCHAR(255))");
      // jdbcTemplate.execute("DROP TABLE feelings IF EXISTS");
      //  jdbcTemplate.execute("CREATE TABLE feelings(" +
            //    "id INT,day INT,niconico VARCHAR(255))");



        // Split up the array of whole names into an array of first/last names
        /*List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long","test1891 test21").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
        log.info("Querying for customer records where first_name = 'test1':");
        jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "test1" },
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));*/
    }
}