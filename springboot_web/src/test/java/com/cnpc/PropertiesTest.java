package com.cnpc;

import com.cnpc.comm.CnpcProperties;
import com.cnpc.comm.OtherProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Value("${cnpc.title}")
    private String title;
    @Resource
    private CnpcProperties cnpcProperties;

    @Resource
    private OtherProperties otherProperties;

    @Test
    public void testSingle(){
        System.out.println("title:"+cnpcProperties.getTitle());
        System.out.println("description:"+cnpcProperties.getDescription());
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("description:"+otherProperties.getBlog());
    }
}
