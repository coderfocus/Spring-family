package data.cache.redis.cacheredisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@EnableJpaRepositories
@SpringBootApplication
public class CacheRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheRedisDemoApplication.class, args);
    }

}
