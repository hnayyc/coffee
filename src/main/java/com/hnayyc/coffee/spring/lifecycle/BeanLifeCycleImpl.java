package com.hnayyc.coffee.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycleImpl implements InitializingBean, DisposableBean{

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "Monica Geller";
        System.out.println("BeanLifCycleImpl init by afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        System.out.println("BeanLifCycleImpl destroy by destroy()");
    }

    public void defaultInit() {
        name = "Monica Geller";
        System.out.println("BeanLifCycleImpl init by defaultInit()");
    }

    public void defaultDestroy() {
        System.out.println("BeanLifCycleImpl destroy by defaultDestroy()");
    }

    public void say() {
        System.out.println("The name of BeanLifCycleImpl is : " + this.name);
    }
}
