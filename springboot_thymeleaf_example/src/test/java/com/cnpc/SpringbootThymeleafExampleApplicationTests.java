package com.cnpc;

import com.cnpc.model.User;
import com.cnpc.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootThymeleafExampleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave(){
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setRegTime(new Date());
            user.setAge(22+i);
            user.setUserName("magic"+i);
            user.setPassWord("123456");
            User save = userRepository.save(user);
            System.out.println(save.toString());
        }

    }
    @Test
    public void aVoid(){
        User user = new User();
        user.setRegTime(new Date());
        user.setAge(22);
        user.setId(20L);
        user.setUserName("magic12");
        user.setPassWord("123456");
        System.out.println(user);
        userRepository.save(user);
    }
}
