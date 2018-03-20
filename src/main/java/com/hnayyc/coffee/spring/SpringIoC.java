package com.hnayyc.coffee.spring;

import com.hnayyc.coffee.spring.autowiring.AutoWiringService;
import com.hnayyc.coffee.spring.aware.MoocApplicationContext;
import com.hnayyc.coffee.spring.aware.MoocBeanName;
import com.hnayyc.coffee.spring.beanannotation.BeanAnnotation;
import com.hnayyc.coffee.spring.beanannotation.javabased.AnnotationConfig;
import com.hnayyc.coffee.spring.beanannotation.javabased.GenericConfig;
import com.hnayyc.coffee.spring.beanannotation.javabased.MyDriverManager;
import com.hnayyc.coffee.spring.beanannotation.javabased.Store;
import com.hnayyc.coffee.spring.beanannotation.jsr.JsrService;
import com.hnayyc.coffee.spring.beanannotation.multibean.BeanInterface;
import com.hnayyc.coffee.spring.beanannotation.multibean.BeanInvoker;
import com.hnayyc.coffee.spring.beanannotation.service.InjectionServiceImpl;
import com.hnayyc.coffee.spring.lifecycle.BeanLifeCycle;
import com.hnayyc.coffee.spring.lifecycle.BeanLifeCycleImpl;
import com.hnayyc.coffee.spring.resource.MoocResource;
import com.hnayyc.coffee.spring.scope.BeanScope;
import com.hnayyc.coffee.spring.beanannotation.service.InjectionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringIoC {

    public static void springInjectBeans() {
        String xmlPath = "classpath:spring-ioc-injection.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        InjectionService propertyInjectionService = (InjectionService) context.getBean("propertyInjectionService");
        propertyInjectionService.save("Inject by <property> : ");

        InjectionService constructorArgInjectionService = (InjectionService) context.getBean("constructorArgInjectionService");
        constructorArgInjectionService.save("Inject by <constructor-arg> : ");
    }

    public static void springBeanScope() {
        String xmlPath = "classpath:spring-ioc-beanscope.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        BeanScope beanScope1 = (BeanScope) context.getBean("beanScope");
        beanScope1.say();
        BeanScope beanScope2 = (BeanScope) context.getBean("beanScope");
        beanScope2.say();
    }

    public static void springBeanLifeCycle() {
        String xmlPath = "classpath:spring-ioc-beanscope.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        BeanScope beanScope = (BeanScope) context.getBean("beanScope");
        beanScope.say();
        BeanLifeCycle beanLifeCycle = (BeanLifeCycle) context.getBean("beanInit");
//        beanLifeCycle.say();
        BeanLifeCycleImpl beanLifeCycleImpl = (BeanLifeCycleImpl) context.getBean("beanInitImpl");
//        beanLifeCycleImpl.say();
        // Spring Context释放时，才会调用Bean的destroy()或close()函数。
       context.close();
//       context.destroy();
    }

    public static void springAware() {
        String xmlPath = "classpath:spring-ioc-aware.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        MoocApplicationContext beanMoocAppCtx = (MoocApplicationContext) context.getBean("moocApplicationContext");
        System.out.println("springAware : MoocApplicationContext@" + beanMoocAppCtx.hashCode());

        MoocBeanName beanMoocBeanName = (MoocBeanName) context.getBean("moocBeanName");
    }

    public static void springAutowiring() {
        String xmlPath = "classpath:spring-ioc-autowiring.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        AutoWiringService autoWiringService = (AutoWiringService)context.getBean("autoWiringService");
        autoWiringService.say("auto wiring");
    }

    public static void springBeanAnnotation() {
        String xmlPath = "classpath:spring-ioc-beanannotation.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

//        BeanAnnotation beanAnnotation1 = (BeanAnnotation) context.getBean("beanAnnotation");
//        beanAnnotation1.say("This is test1");
//        beanAnnotation1.myHashCode();
//
//        BeanAnnotation beanAnnotation2 = (BeanAnnotation) context.getBean("beanAnnotation");
//        beanAnnotation2.say("This is test2");
//        beanAnnotation2.myHashCode();
//
//        InjectionService service = (InjectionService) context.getBean("injectionServiceImpl");
//        service.save("this is inejction by autowired on injectionDao test.");

        BeanInvoker beanInvoker = (BeanInvoker) context.getBean("beanInvoker");
        beanInvoker.say();
    }

    public static void springResource() {
        String xmlPath = "classpath:spring-ioc-resource.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        MoocResource moocResource = (MoocResource) context.getBean("moocResource");
        try {
            moocResource.resource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void springConfiguration() {
        // 初始化Spring Context 方法一：加载xml配置文件
        String xmlPath = "classpath:spring-ioc-beanannotation.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);

        // 初始化Spring Context 方法二：通过@Configuration注解
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        // 初始化Spring Context 方法三：本质同方法一，只是用Java代码代替xml指定扫描类目录。
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("com.hnayyc.coffee.spring.beanannotation");
//        context.refresh();

//        Store store = (Store) context.getBean("stringStore");
//        System.out.println(store.getClass().getName());

//        Store integerStore1 = (Store) context.getBean("integerStore");
//        Store integerStore2 = (Store) context.getBean("integerStore");
//        System.out.println("HashCode of integerStore1 is : " + integerStore1.hashCode());
//        System.out.println("HashCode of integerStore2 is : " + integerStore2.hashCode());

//        MyDriverManager myDriverManager = (MyDriverManager) context.getBean("myDriverManager");
//        System.out.println(myDriverManager.getClass().getName());

//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(GenericConfig.class);
//        Store store = (Store)context.getBean("stringStoreTest");

        JsrService service = (JsrService)context.getBean("jsrService");
        service.save();
        context.close();
    }
}
