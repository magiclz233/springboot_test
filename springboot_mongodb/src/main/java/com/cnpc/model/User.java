package com.cnpc.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    public static final long serializableID = -3258839839160856613L;
    private Long id;
    private String userName;
    private String passWord;
        
        
    
}
