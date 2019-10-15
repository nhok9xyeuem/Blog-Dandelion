package BLogDandelion.BLogDandelion;

import BLogDandelion.BLogDandelion.formatter.ThemeFormatter;
import BLogDandelion.BLogDandelion.service.TitleService;
import BLogDandelion.BLogDandelion.service.ThemeService;
import BLogDandelion.BLogDandelion.service.impl.TitleServiceImpl;
import BLogDandelion.BLogDandelion.service.impl.ThemeServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Configuration
    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

        private ApplicationContext appContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            appContext = applicationContext;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            ThemeService themeService = appContext.getBean(ThemeService.class);
            Formatter themeFormatter = new ThemeFormatter(themeService);
            registry.addFormatter(themeFormatter);
        }

    }
}
