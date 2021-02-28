package com.team.app.backend.persistance.dao;

import com.team.app.backend.persistance.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void save(User user);

    void update(User user);

    void delete(Long id);

    User get(Long id);

    Optional<User> findByUsername(String username);

    String getUserPasswordByUsername(String username);

    User getUserByToken(String token);

    void activateByToken(String token);

    boolean checkTokenAvailability(String token);

    boolean checkEmail(String email);

    User getUserByEmail(String email);


}
