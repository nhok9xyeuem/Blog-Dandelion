package BLogDandelion.BLogDandelion.repository;

import BLogDandelion.BLogDandelion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
