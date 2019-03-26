package data.cache.redis.cacheredisdemo.repositories;

import data.cache.redis.cacheredisdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @program: Book 仓储
 * @description:
 * @author: songwenjie
 * @create: 2019-03-26 09:38
 **/
public interface BookRepository extends CrudRepository<Book,Long> {
}
