package com.hnayyc.coffee.ioc.bean;

public class ChineseUserImpl implements IUser {
    @Override
    public void login() {
        System.out.println("注入中文");
    };
}
