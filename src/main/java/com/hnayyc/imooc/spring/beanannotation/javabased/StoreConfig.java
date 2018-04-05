package com.hnayyc.imooc.spring.beanannotation.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StoreConfig {

    @Bean(name = "stringStore", initMethod = "init", destroyMethod = "destroy")
//    @Bean(name = "stringStore")
    // @Bean  // 如果@Bean没有设置bean的名称，此处因为@Bean对方法进行注解，所以方法名称就是bean的id。
    public Store getStringStore() {
        return new StringStore();
    }

    @Bean(name = "integerStore", initMethod = "init", destroyMethod = "destroy")
    @Scope(value = "prototype")
    public Store getIntegerStore() {
        return new IntegerStore();
    }
}
