package com.springbootdatabase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration//구성하는 파일로 사용하겠다.
public class DataSourceConfig {
    //application.properties에 적힌 내용을 토대로 configure
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource()
    {
        return DataSourceBuilder.create().build();//properties에 작성했던 내용을 어노테이션으로 넘겨주면 이 builder가 수행한다.
    }
}
