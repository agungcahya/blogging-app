package com.spring.blog.bloggingapp.Response;

import com.spring.blog.bloggingapp.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogPostResponse {

    private Integer id;
    private UserEntity user;
    private String title;
    private String content;
    private String createdAt;
}
