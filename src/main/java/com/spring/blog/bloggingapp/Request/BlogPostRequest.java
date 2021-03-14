package com.spring.blog.bloggingapp.Request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;

@Setter
@Getter
public class BlogPostRequest {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String createdAt;

}
