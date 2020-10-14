package com.blogcreator.springboot.repository;

import lombok.extern.slf4j.Slf4j;
import model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Repository
public class UserRepositoryImpl implements UserRepository {
    private static ArrayList<User> users = new ArrayList<>();

    @Override
    public void AddUser(User user){
        users.add(new User().withName("Anuwat").withPassword("isNoob").withUUID(UUID.randomUUID()));
    }

    @Override
    public User GetUser() {
        System.out.println(users.get(0).getName());
        System.out.println(users.get(0).getPassword());
        System.out.println(users.get(0).getUUID());
        return users.get(0);
    }

    @Override
    public ArrayList<User> GetUsers() {

        return users;
    }
}
