package data.redis.redistemplatedemo.config;

import data.redis.redistemplatedemo.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.ValidationEvent;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<String,Book> redisTemplateofBook;

    private Book fooBook(){
        Book fooBook = Book.builder()
                .id(1)
                .bookName("foo book")
                .author("foo author")
                .price(58.00)
                .build();
        return fooBook;
    }

    private Book barBook(){
        Book barBook = Book.builder()
                .id(2)
                .bookName("bar book")
                .author("bar author")
                .price(39.00)
                .build();
        return barBook;
    }

    /**
    * @Description: stringOperation
    * @Param: []
    * @return: void
    * @Author: songwenjie
    * @Date: 2019/3/25
    */
    @Test
    public void stringOperation(){
        ValueOperations<String,Book> valueOperations = redisTemplateofBook.opsForValue();
        valueOperations.set("string_book",fooBook());
        //设置一分钟过期时间
        redisTemplateofBook.expire("string_book", 1, TimeUnit.MINUTES);
    }

    /**
     * @Description: listOperation
     * @Param: []
     * @return: void
     * @Author: songwenjie
     * @Date: 2019/3/25
     */
    @Test
    public void listOperation(){
        ListOperations<String,Book> listOperations = redisTemplateofBook.opsForList();
        listOperations.leftPush("list_book", fooBook());
        listOperations.rightPush("list_book", barBook());
        redisTemplateofBook.expire("list_book", 1, TimeUnit.MINUTES);
    }

    /**
     * @Description: setOperation
     * @Param: []
     * @return: void
     * @Author: songwenjie
     * @Date: 2019/3/25
     */
    @Test
    public void setOperation(){
        SetOperations<String,Book> setOperations = redisTemplateofBook.opsForSet();
        setOperations.add("set_book",fooBook());
        setOperations.add("set_book",barBook());
        redisTemplateofBook.expire("set_book", 1, TimeUnit.MINUTES);
    }

    /**
     * @Description: hashOperation
     * @Param: []
     * @return: void
     * @Author: songwenjie
     * @Date: 2019/3/25
     */
    @Test
    public void hashOperation(){
        HashOperations<String,String,Book> hashOperations = redisTemplateofBook.opsForHash();
        hashOperations.put("hash_book", "foo", fooBook());
        hashOperations.put("hash_book", "bar", barBook());
        redisTemplateofBook.expire("hash_book", 1, TimeUnit.MINUTES);
    }

    /**
    * @Description: zSetOperation
    * @Param: []
    * @return: void
    * @Author: songwenjie
    * @Date: 2019/3/25
    */
    @Test
    public void zSetOperation(){
        ZSetOperations<String,Book> zSetOperations = redisTemplateofBook.opsForZSet();
        Book fooBook = fooBook();
        Book barBook = barBook();
        zSetOperations.add("zSet_book",fooBook,fooBook.getPrice());
        zSetOperations.add("zSet_book",barBook,barBook.getPrice());
        redisTemplateofBook.expire("zSet_book", 1, TimeUnit.MINUTES);
    }


    @Test
    public void printRedisConnection(){
        RedisConnectionFactory redisConnectionFactory =  redisTemplateofBook.getConnectionFactory();
        log.info(redisConnectionFactory.toString());
    }
    
}