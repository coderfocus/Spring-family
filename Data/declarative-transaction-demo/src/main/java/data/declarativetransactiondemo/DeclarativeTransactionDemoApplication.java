package data.declarativetransactiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy(exposeProxy = true)
@EnableTransactionManagement
@SpringBootApplication
public class DeclarativeTransactionDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeclarativeTransactionDemoApplication.class, args);
    }
}
