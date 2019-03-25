package data.redis.jedisdemo;

import data.redis.jedisdemo.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-25 17:03
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private JedisPool jedisPool;

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

    //string
    @Test
    public void string(){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.set("string",fooBook().toString());
        }
    }

    //list
    @Test
    public void list(){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.lpush("list",fooBook().toString());
            jedis.rpush("list",barBook().toString());
        }
    }

    //set
    @Test
    public void set(){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.sadd("set",fooBook().toString());
            jedis.sadd("set",barBook().toString());
        }
    }

    //hash
    @Test
    public void hash(){
        try(Jedis jedis = jedisPool.getResource()){
            jedis.hset("hash","foo",fooBook().toString());
            jedis.hset("hash","bar",barBook().toString());
        }
    }

    //zSet
    @Test
    public void zSet(){
        try(Jedis jedis = jedisPool.getResource()){
            Book fooBook = fooBook();
            Book barBook = barBook();
            jedis.zadd("zSet",fooBook.getPrice(),fooBook.toString());
            jedis.zadd("zSet",barBook.getPrice(),barBook().toString());
        }
    }
}
