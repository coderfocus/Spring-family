package data.cache.redis.cacheredisdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void run(){
        //读取缓存
        for (int i = 0; i < 5; i++) {
            log.info("getBook: {}",bookService.getBook(1));
        }

        //更新缓存
        log.info("updateBook: {}",bookService.update(1));
        log.info("Reading after refresh.");
        log.info("getBook: {}",bookService.getBook(1));

        //删除缓存
        log.info("deletBook");
        bookService.delete(1);
        log.info("Reading after delete.");
        log.info("getBook: {}",bookService.getBook(1));
    }
}