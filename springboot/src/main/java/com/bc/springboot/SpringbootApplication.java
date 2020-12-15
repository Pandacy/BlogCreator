package com.bc.springboot;

import com.bc.springboot.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableJpaRepositories
@Import({UserController.class})
public class SpringbootApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
