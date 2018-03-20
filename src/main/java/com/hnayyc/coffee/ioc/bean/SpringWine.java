package com.hnayyc.coffee.ioc.bean;

import com.hnayyc.coffee.ioc.annotation.IsAnnotation;
import com.hnayyc.coffee.ioc.annotation.SetterAnnotation;

import java.lang.reflect.Method;

/**
 * 类似spring容器
 */
public class SpringWine {
    public static SetterBean getBean(){
        SetterBean bean=new SetterBean();
        boolean isAnnotation=SetterBean.class.isAnnotationPresent(IsAnnotation.class);
        if(isAnnotation){
            Method[] method=SetterBean.class.getDeclaredMethods();
            for (Method method2 : method) {
                if(method2.isAnnotationPresent(SetterAnnotation.class)){
                    SetterAnnotation setterAnnotation=method2.getAnnotation(SetterAnnotation.class);
                    System.out.println("AnnotationTest(field=" + method2.getName() + ",nation=" + setterAnnotation.nation() + ")");
                    try {
                        Class<?> clazz=setterAnnotation.nation();
                        IUser iuser=(IUser) clazz.newInstance();
                        bean.setUserdao(iuser);
                        //return bean;
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return bean;
    }
}
