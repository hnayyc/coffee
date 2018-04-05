package com.hnayyc.imooc.spring.tx;


import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账案例业务层实现类
 */
public class AccountByProxyServiceImpl implements AccountByProxyService {

    private AccountByProxyDao accountDao;

    /**
     * 配置文件的<property name="accountDao" ref="accountDao" />需要setter方法进行注入
     */
    public void setAccountDao(AccountByProxyDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 无事务管理
     */
    @Override
    public void transfer(String out, String in, Double money) {
        System.out.println("By Proxy >>>>> out <<<<<");
        accountDao.outMoney(out, money);
        System.out.println("By Proxy >>>>> in <<<<<");
        int i = 1 / 0;
        accountDao.inMoney(in, money);
        System.out.println("By Proxy >>>>> ok <<<<<");
    }
}
