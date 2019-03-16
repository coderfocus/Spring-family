package com.coderfocus.jdbctemplatedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;

@SpringBootApplication
public class JdbctemplateDemoApplication implements CommandLineRunner {

    @Autowired
    private BookDao bookDao;

    @Bean
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("t_book").usingGeneratedKeyColumns("ID");
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbctemplateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = Book.builder()
                .bookName("Spring Boot in Action")
                .author("Craig Walls")
                .price(59.00)
                .build();
        bookDao.insertBook(book);
        bookDao.deleteBook(1);

        Book upBook = Book.builder()
                .bookName("Spring Boot in Action")
                .author("Craig Walls")
                .price(69.00)
                .id(2)
                .build();
        bookDao.updateBook(upBook);

        bookDao.getBook(2);
        bookDao.getBooks();

        bookDao.getBookids();

    }
}
