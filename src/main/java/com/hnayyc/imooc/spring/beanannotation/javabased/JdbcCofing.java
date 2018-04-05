package com.hnayyc.imooc.spring.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:config.xml")
public class JdbcCofing {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")  // ${username}是Java保留变量，读取操作系统的用户名，如：我的thinkpad用户名为YangCheng。
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public MyDriverManager myDriverManager() {
        return new MyDriverManager(url, username, password);
    }
}
