package com.cnpc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    public static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String password;
    private String age;
    private String email;

    public User(){
        super();
    }
    public User(String name,String password,String age,String email){
        super();
        this.age = age;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
