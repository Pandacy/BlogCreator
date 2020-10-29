package com.bc.springboot.service;

import com.bc.springboot.model.User;
import com.bc.springboot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public void AddUser(User user)
    {
        userRepository.save(user);
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(int id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name)
    {
        return userRepository.findByName(name);
    }

    public String DeleteUser(int id){
        userRepository.deleteById(id);
        return "Object Deleted";
    }

    public User UpdateUser(User user){
        User userData = userRepository.findById(user.getId()).orElse(null);
        userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setName(user.getName());
        return userRepository.save(userData);
    }


    /*public UserModel GetUser(long id)
    {
        List<User> users = userService.getUsers();

        return userService.getUser(id);
    }*/

}
