package br.com.lino.lino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class Index {
    
    @GetMapping("/home")
    public String index() {
        return "index.html";
    }



}
