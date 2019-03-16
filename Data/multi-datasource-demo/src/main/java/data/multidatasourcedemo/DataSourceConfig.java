package data.multidatasourcedemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.sql.DataSource;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-16 17:18
 **/
@Configuration
public class DataSourceConfig {

    @Bean
    @Qualifier(value = "fooDataSource")
    @ConfigurationProperties(value = "spring.foo.datasource")
    public DataSource fooDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier(value = "barDataSource")
    @ConfigurationProperties(value = "spring.bar.datasource")
    public DataSource barDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "fooJdbcTemplate")
    public JdbcTemplate fooJdbcTemplate(@Qualifier("fooDataSource")DataSource fooDataSource){
        return new JdbcTemplate(fooDataSource);
    }

//    @Bean(name = "barJdbcTemplate")
    @Bean
    public JdbcTemplate barJdbcTemplate(@Qualifier("barDataSource")DataSource barDataSource){
        return new JdbcTemplate(barDataSource);
    }
}
