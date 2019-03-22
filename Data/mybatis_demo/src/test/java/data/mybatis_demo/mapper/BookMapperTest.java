package data.mybatis_demo.mapper;

import data.mybatis_demo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void save(){
        Book book = Book.builder()
                .bookName("Spring Boot in action")
                .author("Craig Walls")
                .price(59.00)
                .build();
        bookMapper.save(book);
        log.info("save book: {}",book);
    }

    @Test
    public void findById(){
        Book book = bookMapper.findById(1);
        log.info("findById book: {}",book);
    }
}