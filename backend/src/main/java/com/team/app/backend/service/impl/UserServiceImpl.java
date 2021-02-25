package com.team.app.backend.service.impl;

import com.team.app.backend.dto.UserCreateDto;
import com.team.app.backend.exception.UserAlreadyExistsException;
import com.team.app.backend.dto.UserRegistrationDto;
import com.team.app.backend.persistance.dao.UserDao;
import com.team.app.backend.persistance.model.Role;
import com.team.app.backend.persistance.model.User;
import com.team.app.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Locale;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final long ENGLISH_ID = 1L;
    private final long UKRAINE_ID = 1L;

    @Autowired
    private UserDao userDao;



    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }





    @Override
    public User getUserById(Long id) {
        return userDao.get(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userDao.get(id)!=null){
            userDao.delete(id);
            return true;
        }else{
            return false;
        }

    }

    public User createNewUser(UserCreateDto userCreateDto){
        User user = new User();

        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUsername(userCreateDto.getUsername());
        user.setEmail(userCreateDto.getEmail());
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setActivate_link("ttest");
        user.setRegistr_date(new Date());
        user.setRole(new Role(userCreateDto.getRole().getName().equals("admin") ? 3L : 2L ,userCreateDto.getRole().getName()));
        userDao.save(user);
        return userDao.findByUsername(userCreateDto.getUsername());
    }

    public boolean  checkTokenAvailability(String token){
        return userDao.checkTokenAvailability(token);
    }
    @Override
    public void registerNewUserAccount(UserRegistrationDto userDto)
            throws UserAlreadyExistsException {

        if (isUserRegistered(userDto.getUsername())) {
            throw new UserAlreadyExistsException();
        }

        User user = new User();

        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
//        String token =UUID.randomUUID().toString();
//        while(checkTokenAvailability(token)){
//            token =UUID.randomUUID().toString();
//        }
        user.setActivate_link("asdsa");
        user.setRegistr_date(new Date());
        user.setRole(new Role(1L,"USER"));

        userDao.save(user);

    }

    @Override
    public boolean activateUserAccount(String token) {
        boolean check = checkRegistDate(userDao.getUserByToken(token));
        if(check)userDao.activateByToken(token);
        return check;
    }


    @Override
    public boolean checkRegistDate(User user) {
        System.out.println("time"+user.getRegistr_date().getTime() + "    " + new Date().getTime());
        return new Date().getTime()-user.getRegistr_date().getTime()<86400000;
    }

    /**
     * checks if user exists in the database
     * @param username user's username
     * @return true if user exists in the database; otherwise false
     */
    @Override
    public boolean isUserRegistered(String username) {
        return userDao.findByUsername(username) != null;
    }




}
