package com.hnayyc.coffee.spring.beanannotation.javabased;

public class IntegerStore implements Store<Integer> {

    public void init() {
        System.out.println("This is init of IntegerStore.");
    }

    public void destroy() {
        System.out.println("This is destroy of IntegerStore.");
    }
}
