package data.declarativetransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void insertRecordThenRollback() throws RollbackException{
        log.info("before insertRecordThenRollback: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        try{
            testService.insertRecordThenRollback();
        }catch (RollbackException e){
            log.info("after insertRecordThenRollback: {}",jdbcTemplate.queryForObject("select count(*) from test",Long.class));
        }
    }
}