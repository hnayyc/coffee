package com.hnayyc.coffee.spring.lifecycle;

public class BeanLifeCycle {

    private String name;

    public void init() {
        name = "Ross Geller";
        System.out.println("BeanLifCycle init by init()");
    }

    public void destroy() {
        System.out.println("BeanLifCycle destroy by destroy()");
    }

    public void defaultInit() {
        name = "Ross Geller";
        System.out.println("BeanLifCycle init by defaultInit()");
    }

    public void defaultDestroy() {
        System.out.println("BeanLifCycle destroy by defaultDestroy()");
    }

    public void say() {
        System.out.println("The name of BeanLifCycle is : " + this.name);
    }
}
