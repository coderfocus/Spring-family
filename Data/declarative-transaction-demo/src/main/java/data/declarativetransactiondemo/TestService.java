package data.declarativetransactiondemo;
import java.sql.SQLException;

public interface TestService {
    void insertRecord();
    void insertRecordThenRollback() throws RollbackException;

    void timeout() throws Exception;
    void readOnly() throws Exception;

    void rollbackForException() throws Exception;

    void a() throws RollbackException;
    void b() throws RollbackException;
}
