package Data.jpademo.repository;

import Data.jpademo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-20 11:22
 **/

public interface BookRepository extends CrudRepository<Book,Long> {
}
