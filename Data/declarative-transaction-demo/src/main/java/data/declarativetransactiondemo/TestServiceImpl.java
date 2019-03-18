package data.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
