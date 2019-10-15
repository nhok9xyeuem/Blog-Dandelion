package BLogDandelion.BLogDandelion;

//import BLogDandelion.BLogDandelion.formater.BlogFormater;
import BLogDandelion.BLogDandelion.service.BlogService;
//import BLogDandelion.BLogDandelion.service.ThemeService;
import BLogDandelion.BLogDandelion.service.impl.BlogServiceImpl;
//import BLogDandelion.BLogDandelion.service.impl.ThemeServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class BLogDandelionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BLogDandelionApplication.class, args);
    }

    @Bean
    public BlogService blogService() {
        return new BlogServiceImpl();
    }

//    @Bean
//    public ThemeService themeService() {
//        return new ThemeServiceImpl();
//    }

//    @Configuration
//    class WebConfig implements WebMvcConfigurer, ApplicationContextAware {
//
//        private ApplicationContext appContext;
//
//        @Override
//        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//            appContext = applicationContext;
//        }
//
//        @Override
//        public void addFormatters(FormatterRegistry registry) {
//            ThemeService themeService = appContext.getBean(ThemeService.class);
//            Formatter provinceFormatter = new BlogFormater(themeService);
//            registry.addFormatter(provinceFormatter);
//        }

//        @Override
//        public void addInterceptors(InterceptorRegistry registry) {
//            LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//            interceptor.setParamName("lang");
//            registry.addInterceptor(interceptor);
//        }
//    }
}
