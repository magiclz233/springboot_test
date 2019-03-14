package com.cnpc.web;

import com.cnpc.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public User getUser(){
        User user = new User();
        user.setAge( 20 );
        user.setId( 1 );
        user.setName( "录制" );
        user.setSex( "男" );
        return user;
    }
}
