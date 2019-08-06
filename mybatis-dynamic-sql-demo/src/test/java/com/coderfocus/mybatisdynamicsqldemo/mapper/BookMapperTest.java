package com.coderfocus.mybatisdynamicsqldemo.mapper;

import com.coderfocus.mybatisdynamicsqldemo.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.security.auth.message.callback.PrivateKeyCallback;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testGetByName() {
        List<Book> books = bookMapper.getBooks("Java",0.0);
        System.out.println(books.size());
    }

    @Test
    public void testGetByPrice() {
        List<Book> books = bookMapper.getBooks(null,10.0);
        System.out.println(books.size());
    }

    @Test
    public void testGetByNameAndPrice() {
        List<Book> books = bookMapper.getBooks("Java",10.0);
        System.out.println(books.size());
    }
}