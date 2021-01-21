package com.bc.springboot.service;

import com.bc.springboot.model.User;
import com.bc.springboot.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static IUserRepository userRepository;

    public UserService(IUserRepository repository){
        userRepository = repository;
    }


    public User AddUser(User user)
    {
        return userRepository.save(user);
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
        return userRepository.findByName(name).orElse(null);
    }

    public User getUserByToken(String token)
    {
        return userRepository.findByToken(token).orElse(null);
    }

    public String DeleteUser(int id){
        userRepository.deleteById(id);
        return "Object Deleted";
    }

    public User UpdateUser(User user){
        User userData = new User();
        if (user.getId() == null){
            userData = userRepository.findByName(user.getName()).orElse(null);
        }
        else{
            userData = userRepository.findById(user.getId()).orElse(null);
        }
        //userData.setEmail(user.getEmail());
        userData.setPassword(user.getPassword());
        userData.setName(user.getName());
        userData.setToken(user.getToken());
        return userRepository.save(userData);
    }

    public Boolean verify(User user){
        User userData = userRepository.findByName(user.getName()).orElse(null);
        if (user.getPassword().equals(userData.getPassword())){
            return true;
        }
        return false;
    }

    public Boolean isAuthorized(String token){
        User userData = userRepository.findByToken(token).orElse(null);
        if (token.equals(userData.getToken())){
            return true;
        }
        return false;
    }
}
