package data.multidatasourcedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDataSourceTest {

    @Resource
    private JdbcTemplate fooJdbcTemplate;

    @Resource
    private JdbcTemplate barJdbcTemplate;

    @Test
    public void test(){
        fooJdbcTemplate.update("insert into test (name) values ('foo')");
        barJdbcTemplate.update("insert into test (name) values ('bar')");
    }
}