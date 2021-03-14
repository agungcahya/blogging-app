package com.spring.blog.bloggingapp.Service;

import com.spring.blog.bloggingapp.Entity.BlogPostEntity;
import com.spring.blog.bloggingapp.Repository.BlogPostRepository;
import com.spring.blog.bloggingapp.Request.BlogPostRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public List<BlogPostEntity> getListPost(Integer id, Integer userId, String title) {
        return blogPostRepository.getListPost(id, userId, title);
    }

    public BlogPostEntity addPost(BlogPostRequest blogPostRequest) {
        BlogPostEntity blogPostEntity = modelMapper.map(blogPostRequest, BlogPostEntity.class);
        blogPostEntity.setCreatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPostEntity);
    }

    public ResponseEntity updatePost(BlogPostRequest blogPostRequest) {
        if (blogPostRepository.findById(blogPostRequest.getId()).isPresent()) {
            BlogPostEntity blogPostEntity = blogPostRepository.findById(blogPostRequest.getId()).get();
            blogPostEntity.setTitle(blogPostRequest.getTitle());
            blogPostEntity.setContent(blogPostRequest.getContent());
            return ResponseEntity.ok(blogPostRepository.save(blogPostEntity));
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity deletePost(Integer id) {
        if(blogPostRepository.findById(id).isPresent()) {
            blogPostRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

//
//    public ResponseEntity userLogin(String email, String password){
//        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email, password);
//        if (userEntity.isPresent()) {
//            return ResponseEntity.ok(userEntity.get());
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }
}
