package com.martipap.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
@GetMapping("/hello")
    public String getHelloWorld(Model m) {
    String greeting = "Hello World!";
    //m is the hashmap of vars available to thymeleaf
    m.addAttribute("hello", greeting);
    return "hello";
}

@GetMapping("/capitalize/hello")
    public String 

}
