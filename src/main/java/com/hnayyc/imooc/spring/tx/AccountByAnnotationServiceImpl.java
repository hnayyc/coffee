package com.hnayyc.imooc.spring.tx;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Transactional注解属性：
 * propagation   事务传播行为
 * isolation     事务隔离级别
 * readOnly      只读
 * timeout       超时信息
 * rollbackFor   发生哪些异常回滚
 * noRollbackFor 发生哪些异常不回滚
 */
//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT,
//        readOnly = false, timeout = -1, noRollbackForClassName = "", rollbackFor = "")
@Transactional
public class AccountByAnnotationServiceImpl implements AccountByAnnotationService {

    private AccountByAnnotationDao accountDao;

    /**
     * 配置文件的<property name="accountDao" ref="accountDao" />需要setter方法进行注入
     */
    public void setAccountDao(AccountByAnnotationDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 无事务管理
     */
    @Override
    public void transfer(String out, String in, Double money) {
        System.out.println("By Annotation >>>>> out <<<<<");
        accountDao.outMoney(out, money);
        System.out.println("By Annotation >>>>> in <<<<<");
//        int i = 1 / 0;
        accountDao.inMoney(in, money);
        System.out.println("By Annotation >>>>> ok <<<<<");
    }
}
