package com.coderfocus.jdbctemplatedemo;

import lombok.Builder;
import lombok.Data;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-16 13:34
 **/
@Data
@Builder
public class Book {
    private long id;
    private String bookName;
    private String author;
    private double price;
}
