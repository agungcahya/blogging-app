package com.spring.blog.bloggingapp.Service;

import com.spring.blog.bloggingapp.Controller.UserController;
import com.spring.blog.bloggingapp.Entity.UserEntity;
import com.spring.blog.bloggingapp.Repository.UserRepository;
import com.spring.blog.bloggingapp.Request.UserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final ModelMapper modelMapper = new ModelMapper();
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    public UserEntity addUser(UserRequest userRequest){
        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);
        return userRepository.save(userEntity);
    }

    public ResponseEntity userLogin(String email, String password){
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email, password);
        if (userEntity.isPresent()) {
            return ResponseEntity.ok(userEntity.get());
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
