package com.cnpc.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false,length = 40)
    private String name;
    @Column(nullable = false,length = 40)
    private String className;
    @Column(nullable = false,length = 10)
    private Double score;

        public Student(){
            super();
        }

        public Student(String name,String className,double score){
            this.className =className;
            this.name = name;
            this.score = score;
        }

}
