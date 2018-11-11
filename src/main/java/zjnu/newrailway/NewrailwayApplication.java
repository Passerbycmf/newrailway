package zjnu.newrailway;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement
@MapperScan("zjnu.newrailway.project.*.mapper")
public class NewrailwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewrailwayApplication.class, args);
    }

}