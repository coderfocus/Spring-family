package data.declarativetransactiondemo;
import java.sql.SQLException;

public interface TestService {
    void insertRecord();
    void insertRecordThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;

    void timeout() throws Exception;
    void readOnly() throws Exception;

    void rollbackForException() throws Exception;
}
