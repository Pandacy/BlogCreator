package com.bc.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogModel {
    private Integer id;

    private String title;

    private String Description;

    private UserModel user;

    private String token;
}
