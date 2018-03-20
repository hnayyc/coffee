package com.hnayyc.coffee.spring.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基于泛型的自动装配
 */
@Configuration
public class GenericConfig {

    // TODO 把下面两个成员变量改成List测试@Autowired对于泛型的注解。
    @Autowired
    private Store<String> stringStore;

    @Autowired
    private Store<Integer> integerStore;

    @Bean
    public StringStore stringStore() {
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore() {
        return new IntegerStore();
    }

    // 在此使用@Bean注解，是因为要做到在测试的时候可以直接调用stringStoreTest()方法，执行里面的两句println()而已，没别的意思。
    // 只是，一旦被@Bean注解，函数不能使用void返回值，必须返回一个对象。
    @Bean(name = "stringStoreTest")
    public StringStore stringStoreTest() {
        System.out.println("stringStore : " + this.stringStore.getClass().getName());
        System.out.println("integerStore : " + this.integerStore.getClass().getName());
        return new StringStore();
    }
}
