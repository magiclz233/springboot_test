package com.cnpc.model;

import com.sun.corba.se.spi.orb.StringPair;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private Date regTime;

    public User(String userName, String passWord,int age,Date regTime){
        super();
        this.age = age;
        this.userName = userName;
        this.passWord = passWord;
        this.regTime = regTime;
    }
}
