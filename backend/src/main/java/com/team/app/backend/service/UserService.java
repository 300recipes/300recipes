package com.team.app.backend.service;


import com.team.app.backend.dto.UserCreateDto;
import com.team.app.backend.dto.UserRegistrationDto;
import com.team.app.backend.exception.UserAlreadyExistsException;
import com.team.app.backend.persistance.model.User;

public interface UserService {

    User getUserById(Long id);

    User getUserByUsername(String username);

    boolean deleteUser(Long id);

    boolean  checkTokenAvailability(String token);

    void registerNewUserAccount(UserRegistrationDto userDto) throws UserAlreadyExistsException;

    boolean activateUserAccount(String token);

    boolean checkRegistDate(User user);

    boolean isUserRegistered(String username);

    User findByUsername(String username);

}
