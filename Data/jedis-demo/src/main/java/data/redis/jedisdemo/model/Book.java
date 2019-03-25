package data.redis.jedisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-25 17:04
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    /**
     * 书籍主键
     */
    private long id;
    /**
     * 书籍名称
     */
    private String bookName;
    /**
     * 作者
     */
    private String author;
    /**
     * 价格
     */
    private double price;
}
