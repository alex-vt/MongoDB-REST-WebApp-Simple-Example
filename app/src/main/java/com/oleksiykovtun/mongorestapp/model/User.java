package com.oleksiykovtun.mongorestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oleksiykovtun.mongorestapp.util.Base64Converter;

/**
 * User model (POJO)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Entry {

    private String name;
    private String password;

    public User() { }

    public User(String name, String password) {
        setName(name);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.id = User.class.getSimpleName() + "_" + Base64Converter.getBase64StringFromString(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
