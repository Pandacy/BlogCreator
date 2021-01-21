package com.bc.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private Integer id;

    private String name;

    private String email;

    private String password;

    private String token;
}
