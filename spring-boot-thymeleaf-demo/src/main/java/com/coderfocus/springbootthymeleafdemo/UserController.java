package com.coderfocus.springbootthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/userList/template")
    public String userListTemplate(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User("coder","coder@gmail.com"));
        users.add(new User("focus","focus@gmail.com"));
        users.add(new User("array","array@gmail.com"));
        model.addAttribute("users",users);

//        return "userListTemplate::#table";
        return "userListTemplate::table";
    }

    @GetMapping("/userList")
    public String userList(Model model){
        return "userList";
    }
}
