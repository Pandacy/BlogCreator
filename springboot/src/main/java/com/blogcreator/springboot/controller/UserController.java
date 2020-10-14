package com.blogcreator.springboot.controller;

import com.blogcreator.springboot.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired private UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "Connection Made";
    }

    @RequestMapping("/adduser/")
    public void addUser()
    {
        userRepository.AddUser(new model.User().withName("Anuwat").withPassword("isNoob").withUUID(UUID.randomUUID()));
    }

    @RequestMapping("/getuser/")
    public User getUser()
    {
        User user = userRepository.GetUser();

        return user;
    }

    @RequestMapping("/getusers/")
    public ArrayList<User> getUsers()
    {
        return userRepository.GetUsers();
    }
}
