package com.example.config.bootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBookController {
    @Autowired
    BookProperties bookProperties;
    @GetMapping("/book/hello")
    public String sayHello(){
        return "hello," +  bookProperties.getWriter() + "正在写" + bookProperties.getName();
    }
}
