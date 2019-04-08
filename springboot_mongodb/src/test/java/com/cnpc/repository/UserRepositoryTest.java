package com.cnpc.repository;

import com.cnpc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save(){
        for (int i = 0; i <100; i++) {
            User user = new User();
            user.setId( (long)i );
            user.setUserName( "magic"+i );
            user.setPassWord( "password"+i );
            userRepository.save( user );
        }
        System.out.println("成功！");
    }

    @Test
    public void findAll(){
        List<User> users = userRepository.findAll();
        for (User u:users
             ) {
            System.out.println(u.toString());
        }
    }

    @Test
    public void update(){
        User user = new User();
        user.setId( 1L );
        user.setUserName( "罗璋" );
        user.setPassWord( "123456" );
        userRepository.save( user );
        System.out.println("success");
    }
    @Test
    public void testPage(){
        Sort sort =new Sort( Sort.Direction.ASC,"id" );
        Pageable pageable = PageRequest.of( 2,10,sort );
        Page<User> userPage = userRepository.findAll( pageable );
        for (User u:userPage
             ) {
            System.out.println(u.toString());
        }
    }
}
