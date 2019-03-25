package data.redis.jedisdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-25 17:04
 **/
@Configuration
public class RedisConfig {
    @Bean
    @ConfigurationProperties("spring.redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${spring.redis.host}") String host) {
        return new JedisPool(jedisPoolConfig(), host);
    }
}