package BLogDandelion.BLogDandelion.service;


import BLogDandelion.BLogDandelion.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean checkLogin(User user);
    Iterable<User> findAll();
}
