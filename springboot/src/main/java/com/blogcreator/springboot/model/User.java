package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User{
    protected UUID id;
    protected String name;
    protected String password;

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public User withName(String value) {
        setName(value);
        return this;
    }

    public UUID getUUID() {
        return this.id;
    }

    public void setUUID(UUID value) {
        this.id = value;
    }

    public User withUUID(UUID value) {
        setUUID(value);
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public User withPassword(String value) {
        setPassword(value);
        return this;
    }

}