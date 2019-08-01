package com.coderfocus.springbootthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

        return "book";
    }
}
