package data.declarativetransactiondemo;

public interface TestService {
    void insertRecord();
    void insertRecordThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;
}
