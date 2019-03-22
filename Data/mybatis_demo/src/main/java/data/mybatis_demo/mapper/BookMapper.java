package data.mybatis_demo.mapper;

import data.mybatis_demo.model.Book;
import org.apache.ibatis.annotations.*;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-22 11:22
 **/
@Mapper
public interface BookMapper {

    @Insert("insert into t_book (book_name,author,price) " +
            "values (#{bookName},#{author},#{price})")
    Long save(Book book);


    @Select("select * from t_book where id = #{id}")
    @Results({
//            @Result(column = "book_name",property = "bookName")
    })
    Book findById(long id);


}
