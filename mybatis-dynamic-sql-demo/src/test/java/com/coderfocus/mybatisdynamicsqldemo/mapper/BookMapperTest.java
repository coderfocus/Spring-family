package com.coderfocus.mybatisdynamicsqldemo.mapper;

import com.coderfocus.mybatisdynamicsqldemo.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testGetByAuthor() {
        List<Book> books = bookMapper.getBooks2(null,null,"小马哥");
        System.out.println(books.size());
    }

    @Test
    public void testGetBooksByIds() {
        List<Integer> ids = Arrays.asList(1,2,3);
        List<Book> books = bookMapper.getBooksByIds(ids);
        System.out.println(books.size());
    }


    @Test
    public void testOneParameterWithParam() {
        Book book = new Book();
        book.setName("Java");
        book.setPrice(10.0);
        List<Book> books = bookMapper.oneParameterWithParam(book);
        System.out.println(books.size());
    }



}