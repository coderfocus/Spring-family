package Data.jpademo;

import Data.jpademo.model.Book;
import Data.jpademo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-20 14:02
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void save(){
        Book book = Book.builder()
                .bookName("Spring Boot in action")
                .author("Craig Walls")
                .price(59.00)
                .build();
        bookRepository.save(book);
        log.info("save: {}", book);
    }

    @Test
    public void deleteById(){
        bookRepository.deleteById(3L);
    }

    @Test
    public void update(){
        Book book = bookRepository.findById(1L).get();
        if(book != null){
            log.info("before update: {}", book);
            book.setPrice(69.00);
            bookRepository.save(book);
            log.info("after update: {}", book);
        }
    }

    @Test
    public void findAllById(){
        List<Long> ids = new ArrayList<>(1);
        ids.add(1L);

        Iterable<Book> books = bookRepository.findAllById(ids);

        books.forEach(book -> log.info("findAllById: {}", book));
    }

    @Test
    public void findAll(){
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(book -> log.info("findAll: {}", book));
    }
}
