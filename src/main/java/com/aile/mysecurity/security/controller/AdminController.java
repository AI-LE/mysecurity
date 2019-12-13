package com.aile.mysecurity.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author aile
 * @Date 2019/12/13 16:57
 */
@Controller
@RequestMapping
public class AdminController {

    @RequestMapping
    public String index(){
        return "index";
    }

}
