package com.hnayyc.imooc.spring.beanannotation.service;

import com.hnayyc.imooc.spring.beanannotation.dao.InjectionDao;

public class ConstructorArgInjectionService implements InjectionService {

    private InjectionDao injectionDao;

    // 构造注入：对应<constructor-arg>注入
    public ConstructorArgInjectionService(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
        System.out.println("通过<constructor-arg>使用构造函数注入");
    }

    public void save(String arg) {
        System.out.println("Service接收参数：" + arg);
        arg = arg + this.hashCode();
        injectionDao.save(arg);
    }
}
