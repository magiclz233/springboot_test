package com.cnpc.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class UserControllerTest {


    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void getUser() throws Exception {
       String s = mockMvc.perform( MockMvcRequestBuilders.post( "/getUser" ) )
               .andReturn().getResponse().getContentAsString();
       System.out.println(s);
    }

    @Test
    public void getUserList() throws Exception {
        String s = mockMvc.perform( MockMvcRequestBuilders.get( "/getUserList" ) )
                .andReturn().getResponse().getContentAsString();
        System.out.println(s);
    }

    @Test
    public void saveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("id","3")
                .param("name","")
                .param("sex","男")
                .param("age","150"));


    }
}
