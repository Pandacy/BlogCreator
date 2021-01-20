package com.bc.springboot.controller;

import com.bc.springboot.service.UserService;
import com.bc.springboot.model.User;
import com.bc.springboot.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

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
        userService.AddUser(userFromRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(userFromRequest).toUri();
        return ResponseEntity.created(uri).body(userFromRequest);
    }

    @PostMapping(path = "/login")
    public String generateToken(@RequestBody final User userFromRequest) throws Exception {
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("name", "pass"));
        if (userService.verify(userFromRequest)){
            String token = jwtUtil.generateToken(userFromRequest.getName());
            userFromRequest.setToken(token);
            userService.UpdateUser(userFromRequest);
            return token;
        }
        return "";
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> put(@RequestBody final User userFromRequest, @PathVariable final int id) {
        userFromRequest.setId(id);
        userService.UpdateUser(userFromRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(userFromRequest).toUri();
        return ResponseEntity.created(uri).body(userFromRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<User>> delete(@PathVariable final int id){
        userService.DeleteUser(id);
        List<User> allUsers = userService.getUsers();
        return ResponseEntity.ok(allUsers);
    }
}
