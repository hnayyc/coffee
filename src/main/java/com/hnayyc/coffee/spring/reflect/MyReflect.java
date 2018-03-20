package com.hnayyc.coffee.spring.reflect;

import com.hnayyc.coffee.spring.beanannotation.jsr.JsrService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyReflect {

    public void loadOfficeByBean() {
        String xmlPath = "classpath:reflect.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        Office office = (Office)context.getBean("office");
        office.printInfo();
    }

    public void loadOfficeByName() {
        String officeName = "com.hnayyc.coffee.reflect.Word";
        Class cls = null;
        try {
            cls = Class.forName(officeName);
            Office office = (Office)cls.newInstance();
            office.printInfo();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void invokMethod() {
        Class cls = JsrService.class;
        try {
            Method init = cls.getDeclaredMethod("init");
            Method destroy = cls.getDeclaredMethod("destroy");
            init.invoke(cls.newInstance());
            destroy.invoke(cls.newInstance());
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
       catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void classInfo() {
        Class cls = Word.class;

        Class[] iArry = cls.getInterfaces();
        for(Class i : iArry) {
            System.out.println("Interface name : " + i.getName());
        }
        System.out.println("class name : " + cls.getName());
        System.out.println("supper class name : " + cls.getSuperclass());
        System.out.println("package name : " + cls.getPackage().toString());

        Annotation[] annotationArry = cls.getDeclaredAnnotations();
        for(int i=0; i<annotationArry.length; i++) {
            System.out.println("Annotation of Class: " + annotationArry[i]);
        }

        Constructor[] constructorArry = cls.getDeclaredConstructors();
        for(int i=0; i<constructorArry.length; i++) {
            System.out.println("Constructor : " + constructorArry[i]);
            Constructor constructor = constructorArry[i];
            Annotation[] annoArry = constructor.getDeclaredAnnotations();
            for(int j=0; j<annoArry.length; j++) {
                System.out.println("Annotation of Constructor : " + annoArry[j]);
            }
        }

        Method[] methodArry = cls.getDeclaredMethods();
        for(int i=0; i<methodArry.length; i++) {
            System.out.println("Method : " + methodArry[i]);
            Method method = methodArry[i];
            Annotation[] annoArry = method.getDeclaredAnnotations();
            for(int j=0; j<annoArry.length; j++) {
                System.out.println("Annotation of Method : " + annoArry[j]);
            }
        }

        Field[] fieldArry = cls.getDeclaredFields();
        for(int i=0; i<fieldArry.length; i++) {
            System.out.println("Filed : " + fieldArry[i]);
            Field field = fieldArry[i];
            Annotation[] annoArry = field.getDeclaredAnnotations();
            for(int j=0; j<annoArry.length; j++) {
                System.out.println("Annotation of Field : " + annoArry[j]);
            }
        }
    }
}
