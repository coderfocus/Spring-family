package data.cache.redis.cacheredisdemo.service;

import data.cache.redis.cacheredisdemo.model.Book;
import data.cache.redis.cacheredisdemo.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Book 业务逻辑
 * @description:
 * @author: songwenjie
 * @create: 2019-03-26 09:36
 **/
//@CacheConfig(cacheNames = "book")
@Slf4j
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Cacheable(value = "book")
    public Book getBook(long id){
        log.info("Reading from database");
        return bookRepository.findById(id).get();
    }

    @CachePut(value = "book")
    public Book update(long id){
        Book book = bookRepository.findById(id).get();
        book.setPrice(99.00);
        bookRepository.save(book);
        return book;
    }

    @Caching
    @CacheEvict(value = "book")
    public void delete(long id){
    }
}
