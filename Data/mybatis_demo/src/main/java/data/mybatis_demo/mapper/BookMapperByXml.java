package data.mybatis_demo.mapper;

import data.mybatis_demo.model.Book;
import org.apache.ibatis.annotations.*;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-22 14:25
 **/
@Mapper
public interface BookMapperByXml {

    Long save(Book book);

    Book findById(long id);
}
