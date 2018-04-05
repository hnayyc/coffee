package com.hnayyc.imooc.spring.tx;


/**
 * 转账案例业务层实现类
 */
public class AccountByAspectjServiceImpl implements AccountByAspectjService {

    private AccountByAspectjDao accountDao;

    /**
     * 配置文件的<property name="accountDao" ref="accountDao" />需要setter方法进行注入
     */
    public void setAccountDao(AccountByAspectjDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 无事务管理
     */
    @Override
    public void transfer(String out, String in, Double money) {
        System.out.println("By Aspectj >>>>> out <<<<<");
        accountDao.outMoney(out, money);
        System.out.println("By Aspectj >>>>> in <<<<<");
//        int i = 1 / 0;
        accountDao.inMoney(in, money);
        System.out.println("By Aspectj >>>>> ok <<<<<");
    }
}
