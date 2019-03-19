package com.cnpc.repository;

import com.cnpc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName( "magic" );
        user.setPassword( "123456" );
        user.setAge( 23 );
        System.out.println( user );
        userRepository.save( user );
    }

    @Test
    public void testUpdate() {
        User user = new User( "罗璋", "123456", 21 );
        user.setId( 1L );
        System.out.println( user );
        userRepository.update( user );
        System.out.println( userRepository.findById( 1 ) );
    }

    @Test
    public void testQueryOne() {
        User user = userRepository.findById( 1 );
        System.out.println( "user == " + user.toString() );
    }

    @Test
    public void delete(){
        System.out.println(userRepository.findALL());
        userRepository.delete( 3 );
        System.out.println(userRepository.findALL());
    }
    @Test
    public void findAll(){
       System.out.println(userRepository.findALL());
    }
}
