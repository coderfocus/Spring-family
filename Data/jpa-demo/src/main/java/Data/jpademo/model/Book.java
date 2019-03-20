package Data.jpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @program: Book 实体类
 * @description:
 * @author: songwenjie
 * @create: 2019-03-20 11:19
 **/
@Data
@Builder
@Entity
@Table(name = "t_book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    //JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
    //TABLE：使用一个特定的数据库表格来保存主键。
    //SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    //IDENTITY：主键由数据库自动生成（主要是自动增长型）
    //AUTO：主键由程序控制。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_name")
    private String bookName;

    private String author;

    private double price;
}
