package com.cnpc.web;

import com.cnpc.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/getUserList")
    public List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setAge( 20 );
        user1.setId( 1 );
        user1.setName( "罗璋" );
        user1.setSex( "男" );
        userList.add(user1);
        User user2 = new User();
        user2.setAge( 20 );
        user2.setId( 2 );
        user2.setName( "张三" );
        user2.setSex( "男" );
        userList.add(user2);
        return userList;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result){
        System.out.println("User"+user);
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list ) {
                System.out.println(error.getCode()+"---"+error.getDefaultMessage());
            }
        }
    }
}
