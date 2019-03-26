package data.redis.redistemplatedemo.config;

import data.redis.redistemplatedemo.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @program:
 * @description: Redis configure class
 * @author: songwenjie
 * @create: 2019-03-25 10:28
 **/
@Configuration
public class RedisConfig {

    /** 
    * @Description:  自定义JedisConnectionFactory
    * @Param: [host] 
    * @return: org.springframework.data.redis.connection.RedisConnectionFactory 
    * @Author: songwenjie 
    * @Date: 2019/3/25 
    */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(@Value("${spring.redis.host}") String host){
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration(host);
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }



    @Bean
    public RedisTemplate<String,Book> redisTemplateofBook (RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Book> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        return redisTemplate;
    }
}
