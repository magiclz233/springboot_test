package com.cnpc.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document( indexName = "customer",type = "customer",shards = 1,replicas = 0,refreshInterval = "-1")
public class Customer {
    private String id;
    private String userName;
    private String  address ;
    private Integer age;

    public Customer(){

    }

    public Customer(String userName,String address,int age){
        this.address = address;
        this.age = age;
        this.userName = userName;
    }
        
        
}
