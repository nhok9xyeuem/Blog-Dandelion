package BLogDandelion.BLogDandelion.securityConfig;

import BLogDandelion.BLogDandelion.service.UserService;
import BLogDandelion.BLogDandelion.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    //tiem userservice
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    /// ma hoa password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder(10);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/title",
                        "/login"
                        //                so tang tat ca moi ng vao duoc
                ).permitAll()

                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST).access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT).access("hasRole('ROLE_ADMIN')")
                .antMatchers(HttpMethod.DELETE).access("hasRole('ROLE_ADMIN')")
                // chinh dinh admin
                .anyRequest().authenticated()
                .and().formLogin().permitAll();
    }
}
