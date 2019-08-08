package com.coderfocus.mybatisdynamicsqldemo.mapper;

import com.coderfocus.mybatisdynamicsqldemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    List<Book> getBooks(@Param("name") String name, @Param("price") Double price);

    List<Book> getBooks2(String name, Double price, String author);

    List<Book> getBooksByIds(@Param("ids") List<Integer> ids);

    List<Book> oneParameterWithParam(@Param("book") Book book);

    List<Book> oneParameterWithoutParam(Book book);

    List<Book> oneBaseParameterWithoutParam(String name);

    List<Book> manyBaseParameterWithoutParam(String name,Double price);

    List<Book> manyCustomParameterWithoutParam(Book book,String name);

    List<Book> oneMapParameterWithoutParam(Map<String,Object> map);




}
