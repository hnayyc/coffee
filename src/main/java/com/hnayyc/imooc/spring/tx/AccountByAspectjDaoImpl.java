package com.hnayyc.imooc.spring.tx;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountByAspectjDaoImpl extends JdbcDaoSupport implements AccountByAspectjDao {

    @Override
    public void outMoney(String out, Double money) {
        String sql = "update imooc_spring_tx set money = money - ? where name = ?";
        this.getJdbcTemplate().update(sql, money, out);
    }

    @Override
    public void inMoney(String in, Double money) {
        String sql = "update imooc_spring_tx set money = money + ? where name = ?";
        this.getJdbcTemplate().update(sql, money, in);
    }
}
