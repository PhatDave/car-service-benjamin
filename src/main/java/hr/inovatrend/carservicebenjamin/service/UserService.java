package hr.inovatrend.carservicebenjamin.service;

import hr.inovatrend.carservicebenjamin.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User addUser(User user);

    boolean deleteUserById(Long id);

    Optional<User> getUserById(Long id);
}