package com.oleksiykovtun.mongorestapp.model;

/**
 * User model (POJO)
 */
public class User extends Entry {

    private String name;
    private String password;

    public User() { }

    public User(String name, String password) {
        setId(name);
        setName(name);
        setPassword(password);
    }

    public void setId(String id) {
        this.id = User.class.getSimpleName() + "_" + id.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
