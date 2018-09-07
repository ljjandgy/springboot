package com.gy.myproject.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GY
 * @Date: 2018/8/30 10:55
 */

@RestController
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome(String name){
        String msg = "Hello World," + name;
        System.out.println(msg);
        return msg;
    }
}
