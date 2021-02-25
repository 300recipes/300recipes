package com.team.app.backend.rest;

import com.team.app.backend.dto.UserLoginDto;

import com.team.app.backend.persistance.model.User;

import com.team.app.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.i18n.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDto requestDto) {
        Map<String, String> model = new HashMap<String, String>();
            String username = requestDto.getUsername();
            System.out.println(username +" "+ requestDto.getPassword());

//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);
            String[] params = new String[]{username};
            if(user == null){
                return ResponseEntity.badRequest().body("failed to login");
            }
            Map<Object, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            response.put("email", user.getEmail());
            response.put("password", user.getPassword());
            response.put("image", user.getImage());

            response.put("role", user.getRole());

            response.put("username", username);

            return ResponseEntity.ok().body(response);


//            model.put("message",messageSource.getMessage("user.invalid", null, LocaleContextHolder.getLocale()));
//            return ResponseEntity
//                    .badRequest()
//                    .body(model);
    }




//    @PostMapping("/recovery")
//    @ResponseBody
//
//    public ResponseEntity recovery(@RequestBody RecoveryDto recoveryDto){
//        String email = recoveryDto.getEmail();
//        System.out.println(email);
//        if(userService.isEmailRegistered(email)){
//            userService.sendRecoveryLetter(email);
//            return ResponseEntity.ok(true);
//        }
//        return ResponseEntity
//                .status(HttpStatus.FORBIDDEN)
//                .body("No such email");
//    }
//    //TO DO
//    @PostMapping("/logout")
//    public Map<String, Object> logout() {
//        Map<String, Object> model = new HashMap<String, Object>();
//        model.put("content", "Hello World");
//        return model;
//    }


}
