package com.example.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    //return 문자 그대로 출력하려면 ResponseBody 어노테이션 적어야함.
    @ResponseBody
    public String index() {
        return "index";
    }

}
