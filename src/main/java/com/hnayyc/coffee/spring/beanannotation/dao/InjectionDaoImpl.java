package com.hnayyc.coffee.spring.beanannotation.dao;

import org.springframework.stereotype.Repository;

@Repository
public class InjectionDaoImpl implements InjectionDao {
    public void save(String arg) {
        System.out.println("Dao保存数据：" + arg);
    }
}
