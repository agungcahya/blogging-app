package com.spring.blog.bloggingapp.Controller;

import com.spring.blog.bloggingapp.Entity.UserEntity;
import com.spring.blog.bloggingapp.Request.LoginRequest;
import com.spring.blog.bloggingapp.Request.UserRequest;
import com.spring.blog.bloggingapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user-management")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping(value = "/registration", consumes = "application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.addUser(userRequest));
    }

    @PostMapping(value = "/user/login")
    public ResponseEntity addUser(@RequestBody LoginRequest loginRequest){
        return userService.userLogin(loginRequest);
    }
}
