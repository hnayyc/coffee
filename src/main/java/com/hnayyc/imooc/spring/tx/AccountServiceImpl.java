package com.hnayyc.imooc.spring.tx;


import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账案例业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    /**
     * 配置文件的<property name="accountDao" ref="accountDao" />需要setter方法进行注入
     */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 无事务管理
     */
    @Override
    public void transfer(String out, String in, Double money) {
        System.out.println("----- out -----");
        accountDao.outMoney(out, money);
        System.out.println("----- in -----");
        int i = 1 / 0;
        accountDao.inMoney(in, money);
        System.out.println("----- ok -----");
    }

    /**
     * 编程式方式实现Spring事务
     */
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * 编程方式实现Spring事务控制
     * 由于使用了匿名内部类使用了外部类的变量，所以transferByProgram的函数列表要用final修饰。
     */
    public void transferByProgram(final String out, final String in, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                System.out.println("by program >>>>> out <<<<<");
                accountDao.outMoney(out, money);
                System.out.println("by program >>>>> in <<<<<");
                int i = 1 / 0;
                accountDao.inMoney(in, money);
                System.out.println("by program >>>>> ok <<<<<");
            }
        });
    }


}
