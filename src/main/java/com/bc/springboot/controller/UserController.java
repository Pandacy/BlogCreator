package com.bc.springboot.controller;

import com.bc.springboot.service.UserService;
import com.bc.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired private UserService userService;

    @RequestMapping("/")
    public String index() {
        //user.AddUser(new UserModel().withName("Anuwat").withPassword("K").withUUID(UUID.randomUUID()));
        User user = new User();
        user.setName("Anuwat");
        user.setId(0);
        user.setPassword("Pass");
        user.setEmail("A@mail.com");
        userService.AddUser(user);
        return "Account has been added.";
    }

    /*@RequestMapping("/getuser")
    public UserModel getAccount()
    {
        return userLogic.GetUser();
    }*/

}
