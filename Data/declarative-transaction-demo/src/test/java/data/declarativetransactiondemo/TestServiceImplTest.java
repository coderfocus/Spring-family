package data.declarativetransactiondemo;

import com.mysql.cj.jdbc.exceptions.MySQLTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestService testService;

    @Test
    public void insertRecord() {
        log.info("before insertRecord: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        testService.insertRecord();
        log.info("after insertRecord: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
    }

    @Test
    public void insertRecordThenRollback(){
        log.info("before insertRecordThenRollback: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        try{
            testService.insertRecordThenRollback();
        }catch (RollbackException e){
            log.info("after insertRecordThenRollback: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        }
    }

    @Test
    public void timeout()  {
        log.info("before timeout: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        try {
            testService.timeout();
        }catch (Exception e){
            log.info("after timeout: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        }
    }

    @Test
    public void readOnly(){
        try {
            testService.readOnly();
        }catch (Exception e){
            log.info("Exception: {}",e.toString());
        }
    }

    @Test
    public void rollbackForException(){
        log.info("before rollbackForException: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        try{
            testService.rollbackForException();
        }catch (Exception e){
            log.info("after rollbackForException: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        }
    }


    @Test
    public void b(){
        log.info("before invoke method b: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        try{
            testService.b();
        }catch (RollbackException e){
            log.info("after invoke method b: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        }
    }

}