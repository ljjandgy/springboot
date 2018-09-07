package com.gy.myproject.login;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @Author: GY
 * @Date: 2018/8/30 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WelcomeControllerTest {

    private MockMvc mvc;


    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new WelcomeController()).build();
    }


    @Test
    public void test() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/welcome?name=GY"));
    }
}
