package hr.inovatrend.carservicebenjamin.repository;

import hr.inovatrend.carservicebenjamin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long aLong);
}