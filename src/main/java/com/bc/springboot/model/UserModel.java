package com.bc.springboot.model;

import java.util.UUID;

public class UserModel {
    protected UUID id;
    protected String name;
    protected String password;

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public UserModel withName(String value) {
        setName(value);
        return this;
    }

    public UUID getUUID() {
        return this.id;
    }

    public void setUUID(UUID value) {
        this.id = value;
    }

    public UserModel withUUID(UUID value) {
        setUUID(value);
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public UserModel withPassword(String value) {
        setPassword(value);
        return this;
    }
}
