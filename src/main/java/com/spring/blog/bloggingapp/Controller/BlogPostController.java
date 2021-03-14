package com.spring.blog.bloggingapp.Controller;

import com.spring.blog.bloggingapp.Entity.BlogPostEntity;
import com.spring.blog.bloggingapp.Request.BlogPostRequest;
import com.spring.blog.bloggingapp.Request.UserRequest;
import com.spring.blog.bloggingapp.Service.BlogPostService;
import com.spring.blog.bloggingapp.Service.UserService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post-management")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/posts")
    public ResponseEntity getListPost(@RequestParam(required = false) Integer id, Integer userId, String title){
        return ResponseEntity.ok(blogPostService.getListPost(id, userId, title));
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity addPost(@RequestBody BlogPostRequest blogPostRequest){
        return ResponseEntity.ok(blogPostService.addPost(blogPostRequest));
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity updatePost(@RequestBody BlogPostRequest blogPostRequest){
        return blogPostService.updatePost(blogPostRequest);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deletePost(@RequestParam Integer id){
        return blogPostService.deletePost(id);
    }
//
//    @PostMapping(value = "/user/login")
//    public ResponseEntity addUser(@RequestParam String email, String password){
//        return userService.userLogin(email, password);
//    }
}
