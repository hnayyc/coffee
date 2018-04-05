package com.hnayyc.imooc.spring;

import com.hnayyc.imooc.spring.tx.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

public class SpringTX {

    public static void transactionStart() {
        String xmlPath = "classpath:spring-tx.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("accountService");
//        accountService.transfer("aaa", "bbb", 200d);
        accountService.transferByProgram("aaa", "bbb", 200d);
    }

    public static void transactionByProxyStart() {
        String xmlPath = "classpath:spring-tx-proxy.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        /**
         * 注意：此处没有注入accountService，而是注入accountServiceProxy，
         *       这是因为accountServiceProxy对accountService增强了事务功能。
         *       即代理类对目标类增强了事务功能，所以必须通过代理类来调用目标方法。
         */
        AccountByProxyService accountService = (AccountByProxyService)context.getBean("accountServiceProxy");
        accountService.transfer("aaa", "bbb", 200d);
    }

    public static void transactionByAspectjStart() {
        String xmlPath = "classpath:spring-tx-aspectj.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        AccountByAspectjService accountService = (AccountByAspectjService)context.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);
    }

    public static void transactionByAnnotationStart() {
        String xmlPath = "classpath:spring-tx-annotation.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        AccountByAnnotationService accountService = (AccountByAnnotationService)context.getBean("accountService");
        accountService.transfer("aaa", "bbb", 200d);
    }
}
