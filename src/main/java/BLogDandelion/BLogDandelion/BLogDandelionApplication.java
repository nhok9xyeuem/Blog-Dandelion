package BLogDandelion.BLogDandelion;

import BLogDandelion.BLogDandelion.service.AuthorService;
import BLogDandelion.BLogDandelion.service.ThemeService;
import BLogDandelion.BLogDandelion.service.TitleService;
import BLogDandelion.BLogDandelion.service.impl.AuthorServiceImpl;
import BLogDandelion.BLogDandelion.service.impl.ThemeServiceImpl;
import BLogDandelion.BLogDandelion.service.impl.TitleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@SpringBootApplication
public class BLogDandelionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BLogDandelionApplication.class, args);
    }

    @Bean
    public TitleService blogService() {
        return new TitleServiceImpl();
    }

    @Bean
    public ThemeService themeService() {
        return new ThemeServiceImpl();
    }
    @Bean
    public AuthorService authorService(){
        return new AuthorServiceImpl();
    }


}
