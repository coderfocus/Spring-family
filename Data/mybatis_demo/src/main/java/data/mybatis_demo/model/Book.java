package data.mybatis_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-22 11:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private long id;
    private String bookName;
    private String author;
    private double price;
}
