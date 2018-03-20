package com.hnayyc.coffee.spring.beanannotation.javabased;

public class MyDriverManager {

    public MyDriverManager(String url, String userName, String password) {
        System.out.println("url : " + url);
        System.out.println("username : " + userName);
        System.out.println("password : " + password);
    }
}
