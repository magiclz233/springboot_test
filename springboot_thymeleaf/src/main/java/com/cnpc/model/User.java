package com.cnpc.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String password;
    private Integer age;

    public User(String name, int age, String pass) {
        this.username = name;
        this.age = age;
        this.password = pass;
    }
}
