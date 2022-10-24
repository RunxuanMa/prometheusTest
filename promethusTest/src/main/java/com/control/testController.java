package com.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class testController {

    @GetMapping(value = "/testTestTest")
    public String test(){
        return "this is test";
    }

}
