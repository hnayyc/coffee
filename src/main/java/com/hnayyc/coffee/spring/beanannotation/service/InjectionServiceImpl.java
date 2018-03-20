package com.hnayyc.coffee.spring.beanannotation.service;


import com.hnayyc.coffee.spring.beanannotation.dao.InjectionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionServiceImpl implements InjectionService {

    @Autowired
    private InjectionDao injectionDao;

    // constructor（构造函数）注入：
//    @Autowired
    public InjectionServiceImpl(InjectionDao injectionDAO) {
        this.injectionDao = injectionDAO;
    }

    // setter（设值注入）注入，与<bean><property/></bean>不同的是，不需要无参数的构造函数。
//    @Autowired
    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接收参数：" + arg);
        arg = arg + ":" + this.hashCode();
        injectionDao.save(arg);
    }
}
