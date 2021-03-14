package com.spring.blog.bloggingapp.Service;

import com.spring.blog.bloggingapp.Entity.BlogPostEntity;
import com.spring.blog.bloggingapp.Entity.CommentEntity;
import com.spring.blog.bloggingapp.Repository.BlogPostRepository;
import com.spring.blog.bloggingapp.Repository.CommentRepository;
import com.spring.blog.bloggingapp.Request.BlogPostRequest;
import com.spring.blog.bloggingapp.Request.CommentRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<CommentEntity> getListComment(Integer postId) {
        return commentRepository.findByPostId(postId);

    }

    public CommentEntity addComment(CommentRequest commentRequest) {
        CommentEntity commentEntity = modelMapper.map(commentRequest, CommentEntity.class);
        commentEntity.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(commentEntity);
    }

    public ResponseEntity updateComment(CommentRequest commentRequest) {
        if (commentRepository.findById(commentRequest.getId()).isPresent()) {
            CommentEntity commentEntity = commentRepository.findById(commentRequest.getId()).get();
            commentEntity.setContent(commentRequest.getContent());
            return ResponseEntity.ok(commentRepository.save(commentEntity));
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity deleteComment(Integer id) {
        if(commentRepository.findById(id).isPresent()) {
            commentRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
