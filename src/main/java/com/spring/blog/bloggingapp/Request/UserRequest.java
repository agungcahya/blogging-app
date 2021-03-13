package com.spring.blog.bloggingapp.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    private Integer id;
    private String email;
    private String name;
    private String password;
}
