package BLogDandelion.BLogDandelion.repository;

import BLogDandelion.BLogDandelion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User,Long> {
}
