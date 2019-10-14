package BLogDandelion.BLogDandelion;

import BLogDandelion.BLogDandelion.service.BlogService;
import BLogDandelion.BLogDandelion.service.impl.BlogServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BLogDandelionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BLogDandelionApplication.class, args);
    }

    @Bean
    public BlogService blogService() {
        return new BlogServiceImpl();

    }

}
