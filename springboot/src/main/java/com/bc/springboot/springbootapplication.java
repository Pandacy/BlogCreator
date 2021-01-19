package com.bc.springboot;

import com.bc.springboot.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
@EnableJpaRepositories
@Import({UserController.class, BlogController.class, BlogLayoutController.class, CommentController.class, MessageController.class, ReportController.class})
public class springbootapplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(springbootapplication.class, args);
    }

}
