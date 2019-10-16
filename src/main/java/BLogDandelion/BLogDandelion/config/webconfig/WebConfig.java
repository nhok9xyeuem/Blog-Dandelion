package BLogDandelion.BLogDandelion.config.webconfig;

import BLogDandelion.BLogDandelion.formatter.ThemeFormatter;
import BLogDandelion.BLogDandelion.service.ThemeService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

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