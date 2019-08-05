package com.coderfocus.springbootthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public String book(Model  model){
        model.addAttribute("date",new Date());
        model.addAttribute("message","hello world");
        String[] books = {"coder","focus"};
        model.addAttribute("books",books);

        List<User> users = new ArrayList<>();
        users.add(new User("coder","coder@gmail.com"));
        users.add(new User("focus","focus@gmail.com"));
        users.add(new User("array","array@gmail.com"));
        model.addAttribute("users",users);

        double id1 = Math.random();
        double id2 = Math.random();
        model.addAttribute("id1",id1);
        model.addAttribute("id2",id2);


        String content = "<h1>coder focus</h2>";
        model.addAttribute("content",content);

        User user = new User("coderfocus","coderfocus@gmail.com");
        model.addAttribute("user",user);

        model.addAttribute("display",false);
        return "book";
    }

    @PostMapping
    public String book(User model){
        return "/success";
    }
}
