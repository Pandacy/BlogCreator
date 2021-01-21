package com.bc.springboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageModel {
    private Integer id;

    private Integer votes;

    private String content;

    private Blog blog;
}
