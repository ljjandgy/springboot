package com.gy.myproject.codeBuiler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 *
 * @author GY
 * @Date 2018-07-13 15:41:57
 */
@Controller
@RequestMapping("/codeBuilder")
public class CodeBuilderController {
    private String PREFIX = "/codeBuilder/";

    /**
     * 跳转到首页
     */
    @RequestMapping("/view")
    public String index() {
        return PREFIX + "codeBuilder.html";
    }

    @RequestMapping("/buildCode")
    public void buildCode(){

    }
}
