package com.spring.blog.bloggingapp.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequest {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private String content;
    private String createdAt;

}
