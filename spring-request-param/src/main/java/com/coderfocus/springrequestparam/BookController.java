package com.coderfocus.springrequestparam;

import org.springframework.web.bind.annotation.*;

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
    public Map<String,Object> getBook2(String bookName,Integer bookCode){
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

    @PostMapping("/addBook")
    public Map<String,Object> addBook(Book book){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", book.getBookName());
        paramMap.put("bookCode", book.getBookCode());
        return paramMap;
    }

    @GetMapping("/getBook3")
    public Map<String,Object> getBook3(Book book){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", book.getBookName());
        paramMap.put("bookCode", book.getBookCode());
        return paramMap;
    }

    @GetMapping("/getBook4/{bookName}")
    public Map<String,Object> getBook4(@PathVariable String bookName){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        return paramMap;
    }


    @GetMapping("/getBook5")
    public Map<String,Object> getBook5(@RequestParam String bookName){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        return paramMap;
    }

    @PostMapping("/postBook2")
    public Map<String,Object> postBook2(@RequestParam String bookName){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        return paramMap;
    }


    @GetMapping("/getBook6")
    public Map<String,Object> getBook6(@RequestBody String bookName){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", bookName);
        return paramMap;
    }

    @PostMapping("/postBook3")
    public Map<String,Object> postBook3(@RequestBody Book book){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", book.getBookName());
        paramMap.put("bookCode", book.getBookCode());
        return paramMap;
    }


    @GetMapping("/getBook7/{bookName}/{bookCode}")
    public Map<String,Object> getBook7(@ModelAttribute Book book){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", book.getBookName());
        paramMap.put("bookCode", book.getBookCode());
        return paramMap;
    }

    @PostMapping("/postBook4")
    public Map<String,Object> postBook4(@ModelAttribute Book book){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bookName", book.getBookName());
        paramMap.put("bookCode", book.getBookCode());
        return paramMap;
    }


}
