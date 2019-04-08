package com.cnpc.repository;

import com.cnpc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        User user = new User();
        user.setId( 3L );
        user.setUserName( "张三" );
        user.setPassWord( "123456" );
        userRepository.saveUser( user );
        System.out.println("success");
    }

    @Test
    public void update(){
        User user = new User();
        user.setId( 4L );
        user.setUserName( "李明" );
        user.setPassWord( "123456" );
        long count = userRepository.updateUser( user );
        if(count == 0){
            System.out.println("失败");
        }else {
            System.out.println("success"+count);
        }
    }
}
