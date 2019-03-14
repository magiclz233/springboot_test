package com.cnpc;

import com.cnpc.comm.CnpcProperties;
import com.cnpc.comm.OtherProperties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest1 {
    @Value("${neo.title}")
    private String title;
    @Resource
    private CnpcProperties properties;
    @Resource
    private OtherProperties otherProperties;

    @Test
    public void testSingle() {
        System.out.println("title:"+properties.getTitle());
        Assert.assertEquals(title,"magic");
    }

    @Test
    public void testMore() throws Exception {
        System.out.println("title:"+properties.getTitle());
        System.out.println("description:"+properties.getDescription());
    }

    @Test
    public void testOther() throws Exception {
        System.out.println("title:"+otherProperties.getTitle());
        System.out.println("blog:"+otherProperties.getBlog());
    }

}
