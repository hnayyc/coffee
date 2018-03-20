package com.hnayyc;

import com.hnayyc.coffee.ioc.bean.SetterBean;
import com.hnayyc.coffee.ioc.bean.SpringWine;
import com.hnayyc.coffee.ioc.service.UserService;
import com.hnayyc.coffee.spring.reflect.MyReflect;
import com.hnayyc.coffee.spring.SpringIoC;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        testReflect();
    }

    public static void testReflect() {
        MyReflect myReflect = new MyReflect();
        myReflect.classInfo();
//        myReflect.invokMethod();
//        myReflect.loadOfficeByBean();
//        myReflect.loadOfficeByName();

    }

    public static void testSpingIoc() {
//        SpringIoC.springInjectBeans();
//        SpringIoC.springBeanScope();
//        SpringIoC.springBeanLifeCycle();
//        SpringIoC.springAware();
//        SpringIoC.springAutowiring();
//        SpringIoC.springBeanAnnotation();
//        SpringIoC.springResource();
        SpringIoC.springConfiguration();
    }

    public static void testSpringWine() {
        SetterBean bean = SpringWine.getBean();
        bean.login_Test();
    }

    public static void testAnnotation() {
        System.out.println( "Hello Coffee IoC !" );
        UserService userService = new UserService();
        userService.saveUser();
    }
}
