package com.hnayyc.imooc.spring.beanannotation.javabased;

public class StringStore implements Store<String> {

    public void init() {
        System.out.println("This is init of StringStore.");
    }

    public void destroy() {
        System.out.println("This is destroy of StringStore.");
    }
}
