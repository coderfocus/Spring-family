package com.coderfocus.jdbctemplatedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-16 13:36
 **/
@Repository
@Slf4j
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int insertBook(Book book) {
        int result = jdbcTemplate.update(
                "insert into t_book(book_name, author,price) values(?,?,?)",
                book.getBookName(),
                book.getAuthor(),
                book.getPrice()
        );
        return result;
    }


    public int deleteBook(long id) {
        int result = jdbcTemplate.update("delete from t_book where id = ?", id);
        return result;
    }

    public int updateBook(Book book) {
        int result = jdbcTemplate.update(
                "update t_book set book_name=?,author=?,price=? where id=?",
                book.getBookName(),
                book.getAuthor(),
                book.getPrice(),
                book.getId());
        return result;
    }

    public Book getBook(long id) {
        Book book = jdbcTemplate.queryForObject("select id,book_name,author,price from t_book where id=?",
                new Object[]{id},
                new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return Book.builder()
                                .id(rs.getLong(1))
                                .bookName(rs.getString(2))
                                .author(rs.getString(3))
                                .price(rs.getDouble(4))
                                .build();
                    }
                });

        log.info("Book : {}", book.toString());

        return book;
    }


    public List<Book> getBooks() {
        List<Book> books = jdbcTemplate.query("select id,book_name,author,price from t_book", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Book.builder()
                        .id(rs.getLong(1))
                        .bookName(rs.getString(2))
                        .author(rs.getString(3))
                        .price(rs.getDouble(4))
                        .build();
            }
        });

        books.forEach(book -> log.info("Book : {}", book.toString()));

        return books;
    }

    public List<Long> getBookids() {
        List<Long> bookids = jdbcTemplate.queryForList("select id from t_book",
                Long.class
        );

        bookids.forEach(id -> log.info("bookid : {}", id));

        return bookids;
    }

}
