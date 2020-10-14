package com.blogcreator.springboot.repository;

import model.User;

import java.util.ArrayList;


public interface UserRepository {
    void AddUser(User user);
    User GetUser();
    ArrayList<User> GetUsers();


    //int InsertPerson(UUID id, User user);

    /*default int AddUser(User user){
        UUID id = UUID.RandomUUid();
        return InsertPerson(id, user);
    }*/
}
