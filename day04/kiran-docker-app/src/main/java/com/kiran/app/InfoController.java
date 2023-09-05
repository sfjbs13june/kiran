package com.kiran.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @GetMapping("/name")
    public String name(){
        return "kiran kosanam";
    }

    @GetMapping("/age")
    public int age(){
        return 7;
    }

    @GetMapping("/address")
    public String address(){
        return "some address";
    }


}
