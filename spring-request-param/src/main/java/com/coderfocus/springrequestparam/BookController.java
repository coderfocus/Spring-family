package com.coderfocus.springrequestparam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/getBook")
    public Map<String,Object> getBook(String bookName){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        return paramMap;
    }

    @GetMapping("/getBook2")
    public Map<String,Object> getBook2(String bookName,int bookCode){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        paramMap.put("bookCode", bookCode);
        return paramMap;
    }

    @PostMapping("/postBook")
    public Map<String,Object> postBook(String bookName){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        return paramMap;
    }


}
