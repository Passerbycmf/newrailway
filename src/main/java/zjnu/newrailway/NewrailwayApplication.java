package zjnu.newrailway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement
@MapperScan("zjnu.newrailway.project.*.mapper")
public class NewrailwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewrailwayApplication.class, args);
    }

}