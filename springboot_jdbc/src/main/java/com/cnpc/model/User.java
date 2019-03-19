package com.cnpc.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;


    public User(String username,String password,Integer age){
        this.password = password;
        this.name = username;
        this.age = age;
    }

    public User(){

    }


}
