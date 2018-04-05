package com.hnayyc.imooc.spring.tx;

/**
 * 转账案例的业务层接口
 */
public interface AccountService {

    /**
     * @param out    转出账户
     * @param in     转入账户
     * @param money  转账金额
     */
    public void transfer(String out, String in, Double money);
}
