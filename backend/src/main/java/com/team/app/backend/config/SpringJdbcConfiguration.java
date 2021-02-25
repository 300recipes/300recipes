package com.team.app.backend.config;

import com.team.app.backend.persistance.dao.UserDao;
import com.team.app.backend.persistance.dao.impl.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.team.app.backend")
public class SpringJdbcConfiguration {
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://ec2-54-155-226-153.eu-west-1.compute.amazonaws.com:5432/d5qfp3ud8qgtc");
        dataSource.setUsername("bhmfowpdxlkxue");
        dataSource.setPassword("ee16316977e8e00abc2df77606ecd09b10e4be3b4ef192013546e9ee10556277");
        return dataSource;
    }
    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getDataSource());
    }
}

