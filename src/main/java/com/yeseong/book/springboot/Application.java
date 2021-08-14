package com.yeseong.book.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

// @EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
/*
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)){
            Application app = ctx.getBean(Application.class);
            app.method();
        }*/
    }
/*
    @Autowired
    private JdbcTemplate jdbc;
    public void method() {
        List<Map<String, Object>> list = this.jdbc.queryForList("select * from property1");
        list.forEach(System.out::println);
    }*/
}

