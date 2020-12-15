package com.bc.springboot.controller;

import com.bc.springboot.service.UserService;
import com.bc.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    @Autowired private UserService userService;

    public UserController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getUsers();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody final User userFromRequest) {
        User user = new User(userFromRequest);
        userService.AddUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(userService.getUserByName(user.getName())).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> put(@RequestBody final User userFromRequest, @PathVariable final int id) {
        User user = new User(userFromRequest);
        user.setId(id);
        userService.UpdateUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(userService.getUserByName(user.getName())).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable final int id){
        userService.DeleteUser(id);
        List<User> allUsers = userService.getUsers();
        return ResponseEntity.ok(allUsers);
    }



}
