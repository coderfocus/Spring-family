package data.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-18 11:24
 **/
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.update("insert into test (name) values ('foo')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertRecordThenRollback() throws RollbackException {
        jdbcTemplate.update("insert into test (name) values ('foo')");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        insertRecordThenRollback();
    }

    @Transactional(timeout = 5)
    public void timeout() throws Exception {
        jdbcTemplate.execute("select sleep(3)");
        jdbcTemplate.update("insert into test (name) values ('foo')");
    }

    @Transactional(readOnly = true)
    public void readOnly() throws Exception {
        jdbcTemplate.update("insert into test (name) values ('foo')");
    }

    @Override
//    @Transactional(rollbackFor = {RollbackException.class,Exception.class})
    @Transactional(rollbackFor = {Exception.class})
    public void rollbackForException() throws Exception {
        jdbcTemplate.update("insert into test (name) values ('foo')");
        throw new Exception();
    }
}
