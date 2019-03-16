package data.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @program: 自定义DataSource配置类
 * @description:
 * @author: songwenjie
 * @create: 2019-03-16 11:57
 **/
@Configuration //声明这是一个配置类
@EnableTransactionManagement //开启事务管理
@PropertySource(value = "classpath:config/datasource.properties") //配置类对应的配置文件
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(env.getProperty("datasource.driverClassName").trim());
        dataSource.setUrl(env.getProperty("datasource.url").trim());
        dataSource.setUsername(env.getProperty("datasource.username").trim());
        dataSource.setPassword(env.getProperty("datasource.password").trim());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
