package com.hnayyc.imooc.spring.beanannotation.jsr;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

//@Service
@Named
public class JsrService {

//    @Resource
    @Inject
    private JsrDao jsrDao;

//    @Resource
    public void setJsrDao(/*@Named("jsrDao")*/JsrDao jsrDao) {
        this.jsrDao = jsrDao;
    }

    @PostConstruct
    public void init() {
        System.out.println("JsrService init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JsrService destroy.");
    }

    public void save() {
        this.jsrDao.save();
    }
}
