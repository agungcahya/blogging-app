package com.spring.blog.bloggingapp.Controller;

import com.spring.blog.bloggingapp.Request.BlogPostRequest;
import com.spring.blog.bloggingapp.Request.CommentRequest;
import com.spring.blog.bloggingapp.Service.BlogPostService;
import com.spring.blog.bloggingapp.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment-management")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity getListPost(@RequestParam Integer postId){
        return ResponseEntity.ok(commentService.getListComment(postId));
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity addPost(@RequestBody CommentRequest commentRequest){
        return ResponseEntity.ok(commentService.addComment(commentRequest));
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateComment(@RequestBody CommentRequest commentRequest){
        return commentService.updateComment(commentRequest);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteComment(@RequestParam Integer id){
        return commentService.deleteComment(id);
    }

}
