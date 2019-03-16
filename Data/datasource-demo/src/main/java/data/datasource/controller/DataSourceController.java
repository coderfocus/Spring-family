package data.datasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-16 10:56
 **/
@RestController
public class DataSourceController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/getDataSource")
    public String getDataSource(){
        return dataSource.toString();
    }

    @GetMapping("/getConnection")
    public String getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        String connectionString = conn.toString();
        conn.close();
        return connectionString;
    }
}
