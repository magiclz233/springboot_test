package com.cnpc.rabbit;


import com.cnpc.model.User;
import com.cnpc.rabbit.entity.UserSender;
import com.cnpc.rabbit.hello.HelloSender;
import com.cnpc.rabbit.many.MSender1;
import com.cnpc.rabbit.many.MSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitHelloTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private MSender1 mSender1;
    @Autowired
    private MSender2 mSender2;
    @Autowired
    private UserSender userSender;
    @Test
    public void hello() throws Exception {
        helloSender.send();
        Thread.sleep( 10001 );
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i <100 ; i++) {
            mSender1.send(i);
        }
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i <100 ; i++) {
            mSender1.send(i);
            mSender2.send( i );
        }
    }

    @Test
    public void user() throws InterruptedException {
        User user = new User();
        user.setName( "magic" );
        user.setAge( 12 );
        user.setPassword( "123" );
        user.setSex( "男" );
        userSender.send( user );
        Thread.sleep(1000l);

    }

}
