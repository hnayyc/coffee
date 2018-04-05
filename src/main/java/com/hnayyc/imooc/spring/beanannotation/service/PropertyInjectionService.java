package com.hnayyc.imooc.spring.beanannotation.service;

import com.hnayyc.imooc.spring.beanannotation.dao.InjectionDao;

public class PropertyInjectionService implements InjectionService {

    private InjectionDao injectionDao;

    public InjectionDao getInjectionDao() {
        return injectionDao;
    }

    // 设置注入：对应<property>注入
    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    public void save(String arg) {
        System.out.println("Service接收参数：" + arg);
        arg = arg + this.hashCode();
        injectionDao.save(arg);
    }
}
