package com.coderfocus.mybatisdynamicsqldemo.mapper;

import com.coderfocus.mybatisdynamicsqldemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> getBooks(@Param("name") String name, @Param("price") Double price);

    List<Book> getBooks2(String name, Double price, String author);

    List<Book> getBooksByIds(@Param("ids") List<Integer> ids);

    List<Book> oneParameterWithParam(@Param("book") Book book);

    List<Book> oneParameterWithoutParam(Book book);

    List<Book> oneBaseParameterWithoutParam(String name);


}
