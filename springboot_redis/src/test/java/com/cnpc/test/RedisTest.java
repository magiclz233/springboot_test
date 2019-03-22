package com.cnpc.test;

import com.cnpc.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStringSave(){
        redisTemplate.opsForValue().set( "git","github" );
        System.out.println("git~~~~~~"+redisTemplate.opsForValue().get("git"));
    }

    @Test
    public void testUserSave(){
        User user = new User( "magic","123456","23","magiclz233@163.com" );
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set( "com.cnpc",user );
        User u =  operations.get( "com.cnpc" );
        System.out.println(u.toString());
    }

    @Test
    public void testUser1Save(){
        User user = new User( "magic1","1234562","22","123@163.com" );
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set( "we",user,100, TimeUnit.MILLISECONDS );
        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       boolean e = redisTemplate.hasKey( "we" );
        if(e){
            System.out.println("存在we");
        }else {
            System.out.println("不存在we");
        }
    }

    @Test
    public void delete(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set( "delete","delete" );
         redisTemplate.delete( "delete" );
        Boolean delete = redisTemplate.hasKey( "delete" );
        if(delete){
            System.out.println("delete  false");
        }else {
            System.out.println("delete true");
        }
    }

    @Test
    public void hash(){
        User user = new User( "magic1","1234562","22","123@163.com" );
        HashOperations<String,Object,Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put( "hash","hash","you" );
        hashOperations.put( "user1","user1",user );
        Object o = hashOperations.get( "hash", "hash" );
        User o1 = (User) hashOperations.get( "user1", "user1" );
        System.out.println(o.toString());
        System.out.println(o1.toString());
    }

    @Test
    public void list(){
        ListOperations list = redisTemplate.opsForList();
        list.leftPush( "list1","magic1" );
        list.leftPush( "list1","magic2" );
        list.leftPush( "list1","magic3" );
        list.leftPush( "list1","magic4" );
        list.leftPush( "list1","magic5" );
        List<String> list1 = list.range( "list1", 0, 4 );
        for (String s:list1) {
            System.out.println(s);
        }
    }

    @Test
    public void set(){
        SetOperations set = redisTemplate.opsForSet();
        set.add( "set1","magic1" );
        set.add( "set1","magic1" );
        set.add( "set1","magic2" );
        set.add( "set1","magic3" );
        set.add( "set1","magic4" );
        set.add( "set2","magic1" );
        set.add( "set2","magic1" );
        set.add( "set2","magic5" );
        set.add( "set2","magic6" );
        set.add( "set2","magic4" );
        Set<String> set1 = set.members( "set1" );

        Set<String> set2 = set.members( "set2" );
        for (String s: set1) {
            System.out.println(s);
        }
        for (String s: set2) {
            System.out.println(s);
        }
    }

    @Test
    public void setObj(){
        SetOperations set = redisTemplate.opsForSet();
        Set<String> difference = set.difference( "set1", "set2" );
        for (String s: difference) {
            System.out.println("difference~~~~"+s);
        }

        Set<String> union = set.union( "set1", "set2" );
        for (String s: union) {
            System.out.println("union~~~~"+s);
        }
    }

    @Test
    public void zSet(){
        ZSetOperations zSet = redisTemplate.opsForZSet();
//        zSet.add( "zset1","magic1",1 );
//        zSet.add( "zset1","magic1",1 );
//        zSet.add( "zset1","magic2",2 );
//        zSet.add( "zset1","magic3",3 );
//        zSet.add( "zset1","magic4",4 );
//        zSet.add( "zset1","magic5",5 );
        Set<String> zset1 = zSet.range( "zset1", 0, 4 );
        Set<String> zset11 = zSet.rangeByScore( "zset1", 1, 3 );
        System.out.println(zset1);
        System.out.println(zset11);
    }
}
