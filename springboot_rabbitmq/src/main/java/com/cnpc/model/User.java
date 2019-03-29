package com.cnpc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;
    private String name;
    private String password;
    private String sex;
    private Integer age;
        
        

        
}
