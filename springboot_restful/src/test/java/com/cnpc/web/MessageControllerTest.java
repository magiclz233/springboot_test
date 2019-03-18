package com.cnpc.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        saveMessages();
    }

    private void  saveMessages()  {
        for (int i=1;i<10;i++){
            final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("text", "text"+i);
            params.add("summary", "summary"+i);
            try {
                MvcResult mvcResult=  mockMvc.perform(MockMvcRequestBuilders.post("/message")
                        .params(params)).andReturn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void saveMessage() throws Exception {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("text", "text");
        params.add("summary", "summary");
        String mvcResult=  mockMvc.perform(MockMvcRequestBuilders.post("/message")
                .params(params)).andReturn().getResponse().getContentAsString();
        System.out.println("Result === "+mvcResult);
    }

    @Test
    public void selectAllMessage() throws Exception {
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/messages"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result====="+contentAsString);
    }

    @Test
    public void selectById() throws Exception{
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/messages"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result序列====="+contentAsString);
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message/1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result第一个====="+mvcResult);
    }

    @Test
    public void modifyMessage() throws Exception{
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message/1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result第一个====="+mvcResult);
        final MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("id","1");
        params.add("text","text111");
        params.add("summary","summary11");
        String modifyResult = mockMvc.perform(MockMvcRequestBuilders.put("/message").params(params))
                .andReturn().getResponse().getContentAsString();
        System.out.println("modifyResult===="+modifyResult);
    }

    @Test
    public void patchMessageText() throws Exception{
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/message/1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result第一个====="+mvcResult);
        final MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("id","1");
        params.add("text","text111");
        String patchMessageText = mockMvc.perform(MockMvcRequestBuilders.patch("/message/text").params(params))
                .andReturn().getResponse().getContentAsString();
        System.out.println("modifyResult===="+patchMessageText);
    }

    @Test
    public void deleteMessage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/message/1")).andReturn();
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/messages"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("Result序列====="+mvcResult);
    }

}
